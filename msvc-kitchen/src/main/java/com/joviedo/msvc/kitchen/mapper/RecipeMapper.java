package com.joviedo.msvc.kitchen.mapper;

import com.joviedo.msvc.kitchen.dto.RecipeBasicDto;
import com.joviedo.msvc.kitchen.dto.RecipeDto;
import com.joviedo.msvc.kitchen.model.entity.RecipeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RecipeMapper {

    @Autowired
    RecipeIngredientMapper ingredientMapper;

    public RecipeDto recipeEntity2Dto(RecipeEntity entity) {
        RecipeDto dto = new RecipeDto();

        dto.setIdRecipe(entity.getIdRecipe());
        dto.setName(entity.getName());
        dto.setTimeToCook(entity.getTimeToCook());
        dto.setIngredients(ingredientMapper.entityList2Dto(entity.getRecipeIngredients()));

        return dto;
    }

    public List<RecipeDto> entityList2Dto(List<RecipeEntity> recipes) {

        List<RecipeDto> dtos = new ArrayList<>();
        for (RecipeEntity recipe : recipes) {
            dtos.add(recipeEntity2Dto(recipe));
        }
        return dtos;
    }

    public RecipeBasicDto entity2BasicDto(RecipeEntity recipe) {

        RecipeBasicDto dto = new RecipeBasicDto();
        dto.setIdRecipe(recipe.getIdRecipe());
        dto.setName(recipe.getName());

        return dto;
    }
}
