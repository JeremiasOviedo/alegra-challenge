package com.joviedo.msvc.kitchen;

import com.joviedo.msvc.kitchen.model.entity.DishEntity;
import com.joviedo.msvc.kitchen.service.DishService;
import com.joviedo.msvc.kitchen.service.impl.DishServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsvcKitchenApplication {

	public static void main(String[] args) {SpringApplication.run(MsvcKitchenApplication.class, args);}}
