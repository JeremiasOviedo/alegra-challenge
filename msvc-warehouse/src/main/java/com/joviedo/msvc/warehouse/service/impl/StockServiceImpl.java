package com.joviedo.msvc.warehouse.service.impl;

import com.joviedo.msvc.warehouse.clients.MarketClient;
import com.joviedo.msvc.warehouse.dto.BuyOrderDto;
import com.joviedo.msvc.warehouse.dto.IngredientDto;
import com.joviedo.msvc.warehouse.dto.PageDto;
import com.joviedo.msvc.warehouse.mapper.BuyOrderMapper;
import com.joviedo.msvc.warehouse.mapper.IngredientMapper;
import com.joviedo.msvc.warehouse.model.QuantitySold;
import com.joviedo.msvc.warehouse.model.RecipeIngredient;
import com.joviedo.msvc.warehouse.model.entity.BuyOrderEntity;
import com.joviedo.msvc.warehouse.model.entity.IngredientEntity;
import com.joviedo.msvc.warehouse.repository.BuyOrderRepo;
import com.joviedo.msvc.warehouse.repository.IngredientRepo;
import com.joviedo.msvc.warehouse.service.StockService;
import com.joviedo.msvc.warehouse.service.UtilService;
import jakarta.servlet.http.HttpServletRequest;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class StockServiceImpl implements StockService {

    @Autowired
    IngredientRepo ingredientRepo;
    @Autowired
    BuyOrderRepo orderRepo;

    @Autowired
    IngredientMapper ingredientMap;

    @Autowired
    MarketClient market;

    @Autowired
    UtilService util;

    @Autowired
    BuyOrderMapper orderMapper;

    @Override
    public boolean checkIngredientStock(RecipeIngredient order) {

        IngredientEntity ingredient = ingredientRepo.findById(order.getIdIngredient())
                .orElseThrow(
                        RuntimeException::new);

        return ingredient.getQuantityInStock() > order.getQuantityNeeded();

    }

    @Override
    public void buyStock(Long idIngredient) {

        IngredientEntity ingredient = ingredientRepo.findById(idIngredient)
                .orElseThrow(
                        RuntimeException::new);

        QuantitySold quantitySold = market.buyStock(ingredient.getName());

        if (quantitySold.getQuantitySold() != 0) {

            int actualStock = ingredient.getQuantityInStock();
            int quantityBought = quantitySold.getQuantitySold();
            int newStock = actualStock + quantityBought;


            BuyOrderEntity buyOrder = new BuyOrderEntity(ingredient.getName(), quantityBought);
            orderRepo.save(buyOrder);

            ingredient.setQuantityInStock(newStock);
            ingredientRepo.save(ingredient);

            System.out.println("Amount bought for ingredient " + ingredient.getName() + ": " + quantityBought);
            System.out.println("Now the warehouse has " + newStock + " of " + ingredient.getName() + " in stock.");
        }


    }

    @Override
    public boolean checkRecipe(List<RecipeIngredient> ingredients) {

        for (RecipeIngredient ingredient : ingredients) {
            while (!checkIngredientStock(ingredient)) {
                buyStock(ingredient.getIdIngredient());
            }
        }
        return true;
    }

    @Override
    public List<IngredientDto> listIngredients() {
        return ingredientMap.entityList2Dto(ingredientRepo.findAll());
    }

    @Override
    public List<IngredientDto> discountIngredientStock(List<RecipeIngredient> recipe) {

        List<IngredientDto> ingredientsUpdated = new ArrayList<>();
        List<Long> ingredientsIds = recipe.stream().map(RecipeIngredient::getIdIngredient).toList();
        List<IngredientEntity> ingredientsInStock = ingredientRepo.findByIdIngredientIn(ingredientsIds);

        for (RecipeIngredient recipeIngredient : recipe) {

            IngredientEntity ingredientInStock = ingredientsInStock.stream()
                    .filter(i -> i.getIdIngredient().equals(recipeIngredient.getIdIngredient()))
                    .findFirst()
                    .orElseThrow(() -> new ObjectNotFoundException(recipeIngredient.getIdIngredient(),
                            IngredientEntity.class.getSimpleName()));

            int actualStock = ingredientInStock.getQuantityInStock();
            int updatedStock = actualStock - recipeIngredient.getQuantityNeeded();
            ingredientInStock.setQuantityInStock(updatedStock);

            ingredientsUpdated.add(ingredientMap.ingredientEntity2Dto(ingredientInStock));

            System.out.println("Used " + recipeIngredient.getQuantityNeeded() + " units of " + ingredientInStock.getName());
            System.out.println("Now the warehouse have " + updatedStock + " in stock");
        }

        ingredientRepo.saveAll(ingredientsInStock);

        return ingredientsUpdated;
    }

    @Override
    public PageDto<BuyOrderDto> listBuyOrders(Pageable page, HttpServletRequest request) {
        PageDto<BuyOrderDto> pageDto = new PageDto<>();
        Map<String, String> links = new HashMap<>();
        List<BuyOrderDto> listDto = new ArrayList<>();
        Page<BuyOrderEntity> elements = orderRepo.findAllByOrderByCreationDateDesc(page);

        elements.getContent().forEach(element -> listDto.add(orderMapper.orderEntity2Dto(element)));
        links.put("next", elements.hasNext() ? util.makePaginationLink(request, page.getPageNumber() + 1) : "");
        links.put("previous", elements.hasPrevious() ? util.makePaginationLink(request, page.getPageNumber() - 1) : "");

        pageDto.setContent(listDto);
        pageDto.setLinks(links);

        return pageDto;
    }


}
