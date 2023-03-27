package com.joviedo.msvc.kitchen.dto;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.joviedo.msvc.kitchen.model.entity.RecipeIngredient;

import java.util.List;


public class RecipeDto {

    private Long idRecipe;
    private String name;
    private int timeToCook;
    private List<RecipeIngredientDto> ingredients;

    // Getters & Setters


    public Long getIdRecipe() {
        return idRecipe;
    }

    public void setIdRecipe(Long idRecipe) {
        this.idRecipe = idRecipe;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<RecipeIngredientDto> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<RecipeIngredientDto> ingredients) {
        this.ingredients = ingredients;
    }

    public int getTimeToCook() {
        return timeToCook;
    }

    public void setTimeToCook(int timeToCook) {
        this.timeToCook = timeToCook;
    }
}
