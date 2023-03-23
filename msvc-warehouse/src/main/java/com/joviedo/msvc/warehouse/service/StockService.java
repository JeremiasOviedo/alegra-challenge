package com.joviedo.msvc.warehouse.service;

import com.joviedo.msvc.warehouse.model.RecipeIngredient;
import com.joviedo.msvc.warehouse.repository.IngredientRepo;
import org.springframework.beans.factory.annotation.Autowired;

public interface StockService {

    boolean checkForStock(RecipeIngredient order);

}
