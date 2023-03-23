package com.joviedo.msvc.kitchen.controller;

import com.joviedo.msvc.kitchen.model.entity.DishEntity;
import com.joviedo.msvc.kitchen.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dish")
public class DishController {

    @Autowired
    DishService dishService;


    @GetMapping()
    public DishEntity test() {

        DishEntity dish = dishService.orderDish();

        return dish;

    }
}
