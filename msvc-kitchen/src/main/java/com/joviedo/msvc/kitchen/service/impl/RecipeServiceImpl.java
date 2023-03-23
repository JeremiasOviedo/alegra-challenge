package com.joviedo.msvc.kitchen.service.impl;

import com.joviedo.msvc.kitchen.model.entity.RecipeEntity;
import com.joviedo.msvc.kitchen.repository.RecipeRepo;
import com.joviedo.msvc.kitchen.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    RecipeRepo recipeRepo;
    List<RecipeEntity> recipes = new ArrayList<>();

    @Override
    public RecipeEntity getRandomRecipe() {
        if (this.recipes.size() == 0) {
            this.recipes = recipeRepo.findAll();
        }
        Random random = new Random();
        int randomNumber = random.nextInt((recipes.size()));

        return this.recipes.get(randomNumber);
    }
}
