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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/kitchen")
@CrossOrigin()
public class KitchenController {

    @Autowired
    DishService dishService;
    @Autowired
    private RecipeService recipeService;


    @GetMapping("/orderDish")
    public DishEntity test() {

        DishEntity dish = dishService.orderDish();

        return dish;

    }

    @GetMapping("/dishOrders")
    public ResponseEntity<PageDto<DishDto>> getDishOrders(@PageableDefault(size = 20) Pageable page,
                                                         HttpServletRequest request) {

        PageDto<DishDto> result = dishService.listAll(page, request);
        return ResponseEntity.status(HttpStatus.OK).body(result);

    }

    @GetMapping("/recipes")
    public ResponseEntity<List<RecipeDto>> getRecipes(){

        List<RecipeDto> recipes = recipeService.listRecipes();
        return ResponseEntity.status(HttpStatus.OK).body(recipes);
    }
}
