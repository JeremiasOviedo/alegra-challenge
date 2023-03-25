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

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

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


    private Queue<DishEntity> preparingQueue = new LinkedList<>();
    private Queue<DishEntity> waitingQueue = new LinkedList<>();
    private final int maxPreparingCapacity = 10;

    @Override
    public DishEntity orderDish() {

        DishEntity dish = new DishEntity();

        dish.setRecipe(recipeService.getRandomRecipe());
        dish.setStatus(DishStatus.WAITING);
        dish = dishRepo.save(dish);
        addDishToQueue(dish);


        return dish;
    }

    @Override
    public PageDto<DishDto> listAll(Pageable page, HttpServletRequest request) {
        PageDto<DishDto> pageDto = new PageDto<>();
        Map<String, String> links = new HashMap<>();
        List<DishDto> listDto = new ArrayList<>();
        Page<DishEntity> elements = dishRepo.findAllByOrderByCreationDateDesc(page);

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

    @Override
    public void cookDish(DishEntity dish) {

        int timeToCook = dish.getRecipe().getTimeToCook();

        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

        Runnable finishDish = () -> {

            recipeService.checkRecipeIngredients(dish.getRecipe());
            warehouseClient.discountStockFromRecipe(dish.getRecipe().getRecipeIngredients());
            dish.setStatus(DishStatus.FINISHED);
            dishRepo.save(dish);
            System.out.println("Dish " + dish.getIdDish() + " is ready.");
            preparingQueue.remove(dish);
            moveNextDishFromWaitingQueueToPreparingQueue();
        };

        executor.schedule(finishDish, timeToCook, TimeUnit.SECONDS);
        executor.shutdown();
    }

    @Override
    public synchronized void addDishToQueue(DishEntity dish) {
        if (preparingQueue.size() < maxPreparingCapacity) {
            preparingQueue.add(dish);
            dish.setStatus(DishStatus.PREPARING);
            dishRepo.save(dish);
            cookDish(dish);
        } else {
            waitingQueue.add(dish);
            dish.setStatus(DishStatus.WAITING);
        }
    }

    @Override
    public synchronized void moveNextDishFromWaitingQueueToPreparingQueue() {
        if (!waitingQueue.isEmpty() && preparingQueue.size() < maxPreparingCapacity) {
            DishEntity nextDish = waitingQueue.poll();
            preparingQueue.add(nextDish);
            nextDish.setStatus(DishStatus.PREPARING);
            dishRepo.save(nextDish);
            cookDish(nextDish);
        }
    }

}



