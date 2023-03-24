package com.joviedo.msvc.kitchen.service;

import com.joviedo.msvc.kitchen.dto.RecipeDto;
import com.joviedo.msvc.kitchen.model.entity.RecipeEntity;

import java.util.List;

public interface RecipeService {

    RecipeEntity getRandomRecipe();

    boolean checkRecipeIngredients(RecipeEntity recipe);

    List<RecipeDto> listRecipes();
}
