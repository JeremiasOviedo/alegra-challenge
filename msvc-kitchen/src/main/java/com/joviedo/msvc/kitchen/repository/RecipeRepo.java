package com.joviedo.msvc.kitchen.repository;

import com.joviedo.msvc.kitchen.model.entity.RecipeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepo extends JpaRepository<RecipeEntity, Long> {
}
