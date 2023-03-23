package com.joviedo.msvc.kitchen.model.entity;

import com.joviedo.msvc.kitchen.enumerated.DishStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "DISHES")
public class DishEntity implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDish;

    private DishStatus status;

    @OneToOne
    private RecipeEntity recipe;

    @CreationTimestamp
    private Date creationDate;


}
