package com.joviedo.msvc.warehouse.model;

public class RecipeIngredient {

    private Long idIngredient;

    private int quantityNeeded;

    //Getters and Setters


    public Long getIdIngredient() {
        return idIngredient;
    }

    public void setIdIngredient(Long idIngredient) {
        this.idIngredient = idIngredient;
    }

    public int getQuantityNeeded() {
        return quantityNeeded;
    }

    public void setQuantityNeeded(int quantityNeeded) {
        this.quantityNeeded = quantityNeeded;
    }
}
