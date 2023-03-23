package com.joviedo.msvc.warehouse.model;

public class RecipeIngredient {

    private Long idIngredient;

    private int quantity;

    //Getters and Setters


    public Long getIdIngredient() {
        return idIngredient;
    }

    public void setIdIngredient(Long idIngredient) {
        this.idIngredient = idIngredient;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
