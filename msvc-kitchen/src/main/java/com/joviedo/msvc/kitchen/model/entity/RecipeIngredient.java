package com.joviedo.msvc.kitchen.model.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="RECIPE_INGREDIENTS")
public class RecipeIngredient implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "INGREDIENT_ID", unique = true)
    private Long idIngredient;

    @Column(name = "QUANTITY")
    private int quantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(!(obj instanceof RecipeIngredient)){
            return false;
        }
        RecipeIngredient o = (RecipeIngredient) obj;
        return this.idIngredient != null && this.idIngredient.equals(o.idIngredient);
    }
}
