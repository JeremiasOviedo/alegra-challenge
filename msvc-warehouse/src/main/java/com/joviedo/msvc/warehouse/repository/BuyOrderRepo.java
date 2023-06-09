package com.joviedo.msvc.warehouse.repository;

import com.joviedo.msvc.warehouse.model.entity.BuyOrderEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyOrderRepo extends JpaRepository<BuyOrderEntity, Long> {

    Page<BuyOrderEntity> findAllByOrderByCreationDateDesc(Pageable pageable);
}
