package com.joviedo.msvc.warehouse.clients;

import com.joviedo.msvc.warehouse.model.QuantitySold;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name= "farmers-market", url = "https://recruitment.alegra.com/api/farmers-market")
public interface MarketClient {

    @GetMapping("/buy")
    QuantitySold buyStock(@RequestParam("ingredient") String ingredient);
}
