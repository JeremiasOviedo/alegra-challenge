package com.joviedo.msvc.kitchen.model.entity;

import com.joviedo.msvc.kitchen.enumerated.DishStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "DISHES")
public class DishEntity implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDish;

    @Column(name="DISH_STATUS")
    private DishStatus status;

    @OneToOne()
    @JoinColumn(name = "RECIPE_ID")
    private RecipeEntity recipe;

    @CreationTimestamp
    private Date creationDate;


    //Getters and Setters

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

    public RecipeEntity getRecipe() {
        return recipe;
    }

    public void setRecipe(RecipeEntity recipe) {
        this.recipe = recipe;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
