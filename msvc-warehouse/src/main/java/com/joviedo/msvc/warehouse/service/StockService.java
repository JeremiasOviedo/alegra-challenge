package com.joviedo.msvc.warehouse.service;

import com.joviedo.msvc.warehouse.model.RecipeIngredient;
import com.joviedo.msvc.warehouse.model.entity.IngredientEntity;
import com.joviedo.msvc.warehouse.repository.IngredientRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface StockService {

    boolean checkForStock(RecipeIngredient order);

    void buyStock(Long idIngredient);

    boolean checkRecipe(List<RecipeIngredient> ingredients);

}
