package com.joviedo.msvc.warehouse.model.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="INGREDIENTS")
public class IngredientEntity implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idIngredient;

    @Column(name="NAME")
    private String name;

    @Column(name="QUANTITY_IN_STOCK")
    private int quantityInStock;

    //Getters and Setters


    public Long getIdIngredient() {
        return idIngredient;
    }

    public void setIdIngredient(Long idIngredient) {
        this.idIngredient = idIngredient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }
}
