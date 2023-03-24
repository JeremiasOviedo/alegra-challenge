package com.joviedo.msvc.kitchen.dto;

import com.joviedo.msvc.kitchen.enumerated.DishStatus;

import java.util.Date;

public class DishDto {

    private Long idDish;
    private DishStatus status;
    private RecipeBasicDto recipe;
    private Date creationDate;

    //Getters & Setters

    public Long getIdDish() {
        return idDish;
    }

    public void setIdDish(Long idDish) {
        this.idDish = idDish;
    }

    public DishStatus getStatus() {
        return status;
    }

    public void setStatus(DishStatus status) {
        this.status = status;
    }

    public RecipeBasicDto getRecipe() {
        return recipe;
    }

    public void setRecipe(RecipeBasicDto recipe) {
        this.recipe = recipe;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
