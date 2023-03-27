package com.joviedo.msvc.kitchen.service;

import com.joviedo.msvc.kitchen.dto.DishDto;
import com.joviedo.msvc.kitchen.dto.PageDto;
import com.joviedo.msvc.kitchen.model.entity.DishEntity;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DishService {

    DishEntity orderDish();

    PageDto<DishDto> listAll(Pageable page, HttpServletRequest request);

    PageDto<DishDto> listByFilter (Pageable page, HttpServletRequest request, String status);

    List<DishDto> listPreparingDishes();

    void cookDish(DishEntity dish);

    void addDishToQueue(DishEntity dish);

    void moveNextDishFromWaitingQueueToPreparingQueue();
}
