package com.joviedo.msvc.kitchen.client;

import com.joviedo.msvc.kitchen.dto.IngredientDto;
import com.joviedo.msvc.kitchen.model.entity.RecipeIngredient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "msvc-warehouse", url = "msvc-warehouse:8000")
public interface WarehouseClient {

    @PostMapping("/check")
    ResponseEntity<?> checkRecipe(@RequestBody List<RecipeIngredient> ingredients);

    @PostMapping("/discountStock")
    ResponseEntity<List<IngredientDto>> discountStockFromRecipe(@RequestBody List<RecipeIngredient> recipe);
}
