package com.joviedo.msvc.warehouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsvcWarehouseApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsvcWarehouseApplication.class, args);
	}

}
