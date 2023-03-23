package com.joviedo.msvc.kitchen.service.impl;

import com.joviedo.msvc.kitchen.enumerated.DishStatus;
import com.joviedo.msvc.kitchen.model.entity.DishEntity;
import com.joviedo.msvc.kitchen.repository.DishRepo;
import com.joviedo.msvc.kitchen.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DishServiceImpl implements DishService {

    @Autowired
    DishRepo dishRepo;

    @Autowired
    RecipeServiceImpl recipeService;

    @Override
    public DishEntity orderDish() {

        DishEntity dish = new DishEntity();
        dish.setRecipe(recipeService.getRandomRecipe());
        dish.setStatus(DishStatus.DELIVERED);
        return dishRepo.save(dish);
    }

}
