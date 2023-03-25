package com.joviedo.msvc.warehouse.service;

import com.joviedo.msvc.warehouse.dto.IngredientDto;
import com.joviedo.msvc.warehouse.model.RecipeIngredient;
import com.joviedo.msvc.warehouse.model.entity.IngredientEntity;

import java.util.List;
import java.util.Optional;

public interface StockService {

    boolean checkIngredientStock(RecipeIngredient order);

    void buyStock(Long idIngredient);

    boolean checkRecipe(List<RecipeIngredient> ingredients);

    List<IngredientDto> listIngredients();

    List<IngredientDto> discountIngredientStock(List<RecipeIngredient> recipe);




}
