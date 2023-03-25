package com.joviedo.msvc.warehouse.service;

import com.joviedo.msvc.warehouse.dto.BuyOrderDto;
import com.joviedo.msvc.warehouse.dto.IngredientDto;
import com.joviedo.msvc.warehouse.dto.PageDto;
import com.joviedo.msvc.warehouse.model.RecipeIngredient;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StockService {

    boolean checkIngredientStock(RecipeIngredient order);

    void buyStock(Long idIngredient);

    boolean checkRecipe(List<RecipeIngredient> ingredients);

    List<IngredientDto> listIngredients();

    List<IngredientDto> discountIngredientStock(List<RecipeIngredient> recipe);

    PageDto<BuyOrderDto> listBuyOrders(Pageable page, HttpServletRequest request);


}
