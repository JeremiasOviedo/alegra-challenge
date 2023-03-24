package com.joviedo.msvc.kitchen.service.impl;

import com.joviedo.msvc.kitchen.dto.DishDto;
import com.joviedo.msvc.kitchen.enumerated.DishStatus;
import com.joviedo.msvc.kitchen.mapper.DishMapper;
import com.joviedo.msvc.kitchen.model.entity.DishEntity;
import com.joviedo.msvc.kitchen.repository.DishRepo;
import com.joviedo.msvc.kitchen.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishServiceImpl implements DishService {

    @Autowired
    DishRepo dishRepo;

    @Autowired
    RecipeServiceImpl recipeService;

    @Autowired
    DishMapper dishMapper;

    @Override
    public DishEntity orderDish() {

        DishEntity dish = new DishEntity();

        dish.setRecipe(recipeService.getRandomRecipe());
        dish.setStatus(DishStatus.PREPARING);

        recipeService.checkRecipeIngredients(dish.getRecipe());
        return dishRepo.save(dish);
    }

    @Override
    public List<DishDto> listAll() {
        return dishMapper.entityList2Dto(dishRepo.findAll());
    }

}
