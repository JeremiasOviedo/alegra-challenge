package com.joviedo.msvc.kitchen.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.joviedo.msvc.kitchen.model.Ingredient;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "RECIPES")
public class RecipeEntity implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRecipe;

    @Column(name = "NAME")
    private String name;

    @Column(name = "TIME_TO_COOK")
    private int timeToCook;

    @JsonIgnore
    @Column(name = "INGREDIENTS")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "RECIPE_ID")
    private List<RecipeIngredient> recipeIngredients;

    @JsonIgnore
    @Transient
    private List<Ingredient> ingredients;

    public RecipeEntity() {
        recipeIngredients = new ArrayList<>();
        ingredients = new ArrayList<>();
    }

    //Getters and Setters


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


    public int getTimeToCook() {
        return timeToCook;
    }

    public void setTimeToCook(int timeToCook) {
        this.timeToCook = timeToCook;
    }

    public void addIngredient(RecipeIngredient ingredient) {

        recipeIngredients.add(ingredient);
    }

    public void removeIngredient(RecipeIngredient ingredient) {

        recipeIngredients.remove(ingredient);
    }

    public List<RecipeIngredient> getRecipeIngredients() {
        return recipeIngredients;
    }

    public void setRecipeIngredients(List<RecipeIngredient> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}
