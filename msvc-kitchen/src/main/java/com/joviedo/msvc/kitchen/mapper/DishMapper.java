package com.joviedo.msvc.kitchen.mapper;

import com.joviedo.msvc.kitchen.dto.DishDto;
import com.joviedo.msvc.kitchen.model.entity.DishEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DishMapper {
    @Autowired
    RecipeMapper recipeMapper;

    public DishDto dishEntity2Dto(DishEntity dish) {

        DishDto dto = new DishDto();
        dto.setIdDish(dish.getIdDish());
        dto.setStatus(dish.getStatus());
        dto.setCreationDate(dish.getCreationDate());
        dto.setRecipe(recipeMapper.entity2BasicDto(dish.getRecipe()));

        return dto;

    }

    public List<DishDto> entityList2Dto(List<DishEntity> dishes) {

        List<DishDto> dtos = new ArrayList<>();
        for (DishEntity dish : dishes) {
            dtos.add(dishEntity2Dto(dish));
        }
        return dtos;
    }
}
