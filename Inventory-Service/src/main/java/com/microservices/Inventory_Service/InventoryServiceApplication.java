package com.microservices.Inventory_Service;

import com.microservices.Inventory_Service.Models.Inventory;
import com.microservices.Inventory_Service.Respositories.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@SpringBootApplication
@EnableDiscoveryClient
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner loadData(InventoryRepository repo){
//		return args -> {
//			repo.save(Inventory.builder().skuCode("IPHONE256").quantity(BigDecimal.valueOf(12)).build());
//			repo.save(Inventory.builder().skuCode("SAMSUNG128").quantity(BigDecimal.valueOf(23)).build());
//		};
//	}

}
