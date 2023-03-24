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
import java.util.Optional;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    IngredientRepo ingredientRepo;

    @Autowired
    MarketClient market;

    @Override
    public boolean checkForStock(RecipeIngredient order) {

        Optional<IngredientEntity> o = ingredientRepo.findById(order.getIdIngredient());
        IngredientEntity ingredient = o.get();

        if (ingredient.getQuantityInStock() > order.getQuantity()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void buyStock(Long idIngredient) {

        Optional<IngredientEntity> object = ingredientRepo.findById(idIngredient);

        if (object.isPresent()) {
            IngredientEntity ingredient = object.get();

            QuantitySold quantitySold = market.buyStock(ingredient.getName());

            int actualStock = ingredient.getQuantityInStock();
            int quantityBought = quantitySold.getQuantitySold();

            ingredient.setQuantityInStock(actualStock + quantityBought);

            ingredientRepo.save(ingredient);
        }

    }

    @Override
    public boolean checkRecipe(List<RecipeIngredient> ingredients) {

        for (RecipeIngredient ingredient : ingredients) {
            while (!checkForStock(ingredient)) {
                buyStock(ingredient.getIdIngredient());
            }

        }

        return true;
    }

}
