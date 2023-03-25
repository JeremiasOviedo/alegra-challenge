package com.joviedo.msvc.warehouse.mapper;

import com.joviedo.msvc.warehouse.dto.BuyOrderDto;
import com.joviedo.msvc.warehouse.model.entity.BuyOrderEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BuyOrderMapper {

    public BuyOrderDto orderEntity2Dto(BuyOrderEntity entity) {

        BuyOrderDto dto = new BuyOrderDto();

        dto.setIdOrder(entity.getIdOrder());
        dto.setIngredient(entity.getIngredient());
        dto.setQuantityBought(entity.getQuantityBought());
        dto.setCreationDate(entity.getCreationDate());

        return dto;

    }

    public List<BuyOrderDto> orderEntityList2Dto(List<BuyOrderEntity> entities) {

        List<BuyOrderDto> dtos = new ArrayList<>();

        for (BuyOrderEntity buyOrder : entities) {
            dtos.add(orderEntity2Dto(buyOrder));
        }
        return dtos;

    }
}
