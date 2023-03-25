package com.joviedo.msvc.warehouse.mapper;

import com.joviedo.msvc.warehouse.dto.IngredientDto;
import com.joviedo.msvc.warehouse.model.entity.IngredientEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class IngredientMapper {

    public IngredientDto ingredientEntity2Dto(IngredientEntity ingredient) {

        IngredientDto dto = new IngredientDto();

        dto.setIdIngredient(ingredient.getIdIngredient());
        dto.setName(ingredient.getName());
        dto.setQuantityInStock(ingredient.getQuantityInStock());

        return dto;
    }

    public List<IngredientDto> entityList2Dto(List<IngredientEntity> ingredients) {

        List<IngredientDto> dtos = new ArrayList<>();
        for (IngredientEntity ingredient : ingredients) {

            dtos.add(ingredientEntity2Dto(ingredient));
        }
        return dtos;
    }

}
