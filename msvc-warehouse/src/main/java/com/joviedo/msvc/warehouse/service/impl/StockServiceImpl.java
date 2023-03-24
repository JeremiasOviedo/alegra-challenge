package com.joviedo.msvc.warehouse.service.impl;

import com.joviedo.msvc.warehouse.clients.MarketClient;
import com.joviedo.msvc.warehouse.model.QuantitySold;
import com.joviedo.msvc.warehouse.model.RecipeIngredient;
import com.joviedo.msvc.warehouse.model.entity.IngredientEntity;
import com.joviedo.msvc.warehouse.repository.IngredientRepo;
import com.joviedo.msvc.warehouse.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class StockServiceImpl implements StockService {

    @Autowired
    IngredientRepo ingredientRepo;

    @Autowired
    MarketClient market;

    @Override
    public boolean checkIngredientStock(RecipeIngredient order) {

        IngredientEntity ingredient = ingredientRepo.findById(order.getIdIngredient())
                .orElseThrow(
                        RuntimeException::new);

        return ingredient.getQuantityInStock() > order.getQuantity();

    }

    @Override
    public void buyStock(Long idIngredient) {

        IngredientEntity ingredient = ingredientRepo.findById(idIngredient)
                .orElseThrow(
                        RuntimeException::new);

        QuantitySold quantitySold = market.buyStock(ingredient.getName());

        int actualStock = ingredient.getQuantityInStock();
        int quantityBought = quantitySold.getQuantitySold();
        int newStock = actualStock + quantityBought;

        ingredient.setQuantityInStock(newStock);
        ingredientRepo.save(ingredient);

        System.out.println("Amount bought for ingredient " + ingredient.getName() + ": " + quantityBought);
        System.out.println("Now the warehouse has " + newStock + " of " + ingredient.getName() + " in stock.");

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

}
