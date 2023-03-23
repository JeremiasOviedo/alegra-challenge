package com.joviedo.msvc.warehouse.repository;

import com.joviedo.msvc.warehouse.model.entity.IngredientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepo extends JpaRepository<IngredientEntity, Long> {

}
