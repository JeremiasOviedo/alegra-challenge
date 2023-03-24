package com.joviedo.msvc.kitchen.client;

import com.joviedo.msvc.kitchen.model.entity.RecipeIngredient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "msvc-warehouse", url = "http://localhost:8000/warehouse")
public interface WarehouseClient {

    @PostMapping("/check")
    ResponseEntity<?> checkRecipe(@RequestBody List<RecipeIngredient> ingredients);
}
