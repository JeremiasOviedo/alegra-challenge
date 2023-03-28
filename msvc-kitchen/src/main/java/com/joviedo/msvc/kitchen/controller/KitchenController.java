package com.joviedo.msvc.kitchen.controller;

import com.joviedo.msvc.kitchen.dto.DishDto;
import com.joviedo.msvc.kitchen.dto.PageDto;
import com.joviedo.msvc.kitchen.dto.RecipeDto;
import com.joviedo.msvc.kitchen.model.entity.DishEntity;
import com.joviedo.msvc.kitchen.service.DishService;
import com.joviedo.msvc.kitchen.service.RecipeService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
@CrossOrigin()
public class KitchenController {

    @Autowired
    DishService dishService;
    @Autowired
    private RecipeService recipeService;


    @PostMapping("/orderDish")
    public DishEntity test() {

        DishEntity dish = dishService.orderDish();

        return dish;

    }

    @GetMapping("/dishOrders")
    public ResponseEntity<PageDto<DishDto>> getDishOrders(@PageableDefault(size = 10) Pageable page,
                                                         HttpServletRequest request, @RequestParam String status) {

        PageDto<DishDto> dishes = dishService.listByFilter(page, request,status);
        return ResponseEntity.status(HttpStatus.OK).body(dishes);

    }

    @GetMapping("/recipes")
    public ResponseEntity<List<RecipeDto>> getRecipes(){

        List<RecipeDto> recipes = recipeService.listRecipes();
        return ResponseEntity.status(HttpStatus.OK).body(recipes);
    }
}
