package com.joviedo.msvc.kitchen.repository;

import com.joviedo.msvc.kitchen.enumerated.DishStatus;
import com.joviedo.msvc.kitchen.model.entity.DishEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DishRepo extends JpaRepository<DishEntity, Long> {

    List<DishEntity> findByStatus(DishStatus status);
    Page<DishEntity> findAllByOrderByCreationDateDesc(Pageable pageable);
}
