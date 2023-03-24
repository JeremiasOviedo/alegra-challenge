package com.joviedo.msvc.warehouse.controller;

import com.joviedo.msvc.warehouse.model.entity.IngredientEntity;
import com.joviedo.msvc.warehouse.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController {

    @Autowired
    StockService stockService;


    @GetMapping("/buyStock")
    public int buyStock(@RequestParam String ingredient){

        return stockService.buyStock(ingredient);

    }
}
