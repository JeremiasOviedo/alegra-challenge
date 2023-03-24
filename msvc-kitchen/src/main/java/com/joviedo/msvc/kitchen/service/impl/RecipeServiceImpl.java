package com.joviedo.msvc.kitchen.service.impl;

import com.joviedo.msvc.kitchen.client.WarehouseClient;
import com.joviedo.msvc.kitchen.dto.RecipeDto;
import com.joviedo.msvc.kitchen.mapper.RecipeMapper;
import com.joviedo.msvc.kitchen.model.entity.RecipeEntity;
import com.joviedo.msvc.kitchen.repository.RecipeRepo;
import com.joviedo.msvc.kitchen.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    RecipeRepo recipeRepo;
    @Autowired
    WarehouseClient warehouseClient;

    @Autowired
    RecipeMapper recipeMapper;
    List<RecipeEntity> recipes = new ArrayList<>();

    @Override
    public RecipeEntity getRandomRecipe() {
        if (recipes.isEmpty()) {
            this.recipes = recipeRepo.findAll();
        }
        Random random = new Random();
        int randomNumber = random.nextInt((recipes.size()));

        return this.recipes.get(randomNumber);
    }

    @Override
    public boolean checkRecipeIngredients(RecipeEntity recipe) {

        ResponseEntity<?> response = warehouseClient.checkRecipe(recipe.getRecipeIngredients());

        return response.getStatusCode().equals(HttpStatus.NO_CONTENT);
    }

    @Override
    public List<RecipeDto> listRecipes() {

        return recipeMapper.entityList2Dto(recipeRepo.findAll());
    }
}
