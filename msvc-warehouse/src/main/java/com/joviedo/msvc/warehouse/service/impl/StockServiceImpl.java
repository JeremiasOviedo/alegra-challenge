package com.joviedo.msvc.warehouse.service.impl;

import com.joviedo.msvc.warehouse.model.RecipeIngredient;
import com.joviedo.msvc.warehouse.model.entity.IngredientEntity;
import com.joviedo.msvc.warehouse.repository.IngredientRepo;
import com.joviedo.msvc.warehouse.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    IngredientRepo ingredientRepo;


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
}
