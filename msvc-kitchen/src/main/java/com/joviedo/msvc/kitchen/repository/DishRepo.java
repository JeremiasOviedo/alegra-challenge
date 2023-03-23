package com.joviedo.msvc.kitchen.repository;

import com.joviedo.msvc.kitchen.model.entity.DishEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DishRepo extends JpaRepository<DishEntity, Long> {
}
