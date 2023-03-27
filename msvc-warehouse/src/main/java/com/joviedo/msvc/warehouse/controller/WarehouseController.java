package com.joviedo.msvc.warehouse.controller;

import com.joviedo.msvc.warehouse.dto.BuyOrderDto;
import com.joviedo.msvc.warehouse.dto.IngredientDto;
import com.joviedo.msvc.warehouse.dto.PageDto;
import com.joviedo.msvc.warehouse.model.RecipeIngredient;
import com.joviedo.msvc.warehouse.service.StockService;
import feign.FeignException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/warehouse")
@CrossOrigin
public class WarehouseController {

    @Autowired
    StockService stockService;


    @PostMapping("/buyStock")
    public ResponseEntity<?> buyStock(@RequestParam Long ingredient) {

        try {
            stockService.buyStock(ingredient);
        } catch (FeignException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Collections.singletonMap("Message", "Theres an error with client communication or " +
                            "cant found ingredient with id: " + ingredient + e.getMessage()));
        }

        return ResponseEntity.ok().build();

    }

    @PostMapping("/check")
    public ResponseEntity<?> checkRecipe(@RequestBody List<RecipeIngredient> ingredients) {

        stockService.checkRecipe(ingredients);
        return ResponseEntity.noContent().build();


    }

    @PostMapping("/discountStock")
    public ResponseEntity<List<IngredientDto>> discountStockFromRecipe(@RequestBody List<RecipeIngredient> recipe) {

        List<IngredientDto> ingredientsUpdated = stockService.discountIngredientStock(recipe);
        return ResponseEntity.status(HttpStatus.OK).body(ingredientsUpdated);

    }

    @GetMapping("/buyOrders")
    public ResponseEntity<PageDto<BuyOrderDto>> getBuyOrders(@PageableDefault(size = 20) Pageable page,
                                                            HttpServletRequest request) {

        PageDto<BuyOrderDto> result = stockService.listBuyOrders(page, request);
        return ResponseEntity.status(HttpStatus.OK).body(result);

    }

    @GetMapping("/stock")
    public ResponseEntity<List<IngredientDto>> getIngredientsInStock(){

        List<IngredientDto> ingredients = stockService.listIngredients();
        return ResponseEntity.status(HttpStatus.OK).body(ingredients);
    }

}
