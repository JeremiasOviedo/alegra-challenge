package com.joviedo.msvc.warehouse.model.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;

@Entity
@Table(name = "BUY_ORDERS")
public class BuyOrderEntity implements Serializable {

    private final static Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idOrder;

    @Column(name = "INGREDIENT")
    private String ingredient;

    @Column(name = "QUANTITY_BOUGHT")
    private int quantityBought;

    @CreationTimestamp
    private LocalDateTime creationDate;

    //Getters & Setters

    public BuyOrderEntity() {
    }

    public BuyOrderEntity(String ingredient, int quantityBought){
        this.ingredient = ingredient;
        this.quantityBought = quantityBought;
    }

    public long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(long idOrder) {
        this.idOrder = idOrder;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public int getQuantityBought() {
        return quantityBought;
    }

    public void setQuantityBought(int quantityBought) {
        this.quantityBought = quantityBought;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }
}
