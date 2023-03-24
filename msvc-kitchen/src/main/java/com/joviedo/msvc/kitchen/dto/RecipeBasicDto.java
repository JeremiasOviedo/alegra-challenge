package com.joviedo.msvc.kitchen.dto;

public class RecipeBasicDto {

    private Long idRecipe;
    private String name;

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
}
