package com.joviedo.msvc.kitchen.service.impl;

import com.joviedo.msvc.kitchen.client.WarehouseClient;
import com.joviedo.msvc.kitchen.dto.DishDto;
import com.joviedo.msvc.kitchen.dto.PageDto;
import com.joviedo.msvc.kitchen.enumerated.DishStatus;
import com.joviedo.msvc.kitchen.mapper.DishMapper;
import com.joviedo.msvc.kitchen.model.entity.DishEntity;
import com.joviedo.msvc.kitchen.repository.DishRepo;
import com.joviedo.msvc.kitchen.service.DishService;
import com.joviedo.msvc.kitchen.service.UtilService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DishServiceImpl implements DishService {

    @Autowired
    DishRepo dishRepo;

    @Autowired
    RecipeServiceImpl recipeService;

    @Autowired
    DishMapper dishMapper;

    @Autowired
    WarehouseClient warehouseClient;

    @Autowired
    UtilService util;

    @Override
    public DishEntity orderDish() {

        DishEntity dish = new DishEntity();

        dish.setRecipe(recipeService.getRandomRecipe());
        dish.setStatus(DishStatus.PREPARING);

        recipeService.checkRecipeIngredients(dish.getRecipe());
        warehouseClient.discountStockFromRecipe(dish.getRecipe().getRecipeIngredients());

        return dishRepo.save(dish);
    }

    @Override
    public PageDto<DishDto> listAll(Pageable page, HttpServletRequest request) {
        PageDto<DishDto> pageDto = new PageDto<>();
        Map<String, String> links = new HashMap<>();
        List<DishDto> listDto = new ArrayList<>();
        Page<DishEntity> elements = dishRepo.findAll(page);

        elements.getContent().forEach(element -> listDto.add(dishMapper.dishEntity2Dto(element)));
        links.put("next", elements.hasNext() ? util.makePaginationLink(request, page.getPageNumber() + 1) : "");
        links.put("previous", elements.hasPrevious() ? util.makePaginationLink(request, page.getPageNumber() - 1) : "");

        pageDto.setContent(listDto);
        pageDto.setLinks(links);

        return pageDto;
    }

    @Override
    public List<DishDto> listPreparingDishes() {
        return dishMapper.entityList2Dto(dishRepo.findByStatus(DishStatus.PREPARING));
    }

}
