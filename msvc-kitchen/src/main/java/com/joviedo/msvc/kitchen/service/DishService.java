package com.joviedo.msvc.kitchen.service;

import com.joviedo.msvc.kitchen.dto.DishDto;
import com.joviedo.msvc.kitchen.model.entity.DishEntity;

import java.util.List;

public interface DishService {

    DishEntity orderDish();
    List<DishDto> listAll();
}
