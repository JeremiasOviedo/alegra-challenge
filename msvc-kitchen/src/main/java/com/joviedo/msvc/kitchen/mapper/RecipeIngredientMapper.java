package com.joviedo.msvc.kitchen.mapper;

import com.joviedo.msvc.kitchen.dto.RecipeIngredientDto;
import com.joviedo.msvc.kitchen.model.entity.RecipeIngredient;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RecipeIngredientMapper {

    RecipeIngredientDto recipeIngredientEntity2Dto(RecipeIngredient ingredient){

        RecipeIngredientDto dto = new RecipeIngredientDto();

        dto.setIdIngredient(ingredient.getIdIngredient());
        dto.setIngredientName(ingredient.getIngredientName());
        dto.setQuantityNeeded(ingredient.getQuantityNeeded());

        return dto;
    }

    List<RecipeIngredientDto> entityList2Dto(List<RecipeIngredient> ingredients){

        List<RecipeIngredientDto> dtos = new ArrayList<>();

        for(RecipeIngredient ingredient : ingredients){
            dtos.add(recipeIngredientEntity2Dto(ingredient));
        }
        return dtos;
    }
}
