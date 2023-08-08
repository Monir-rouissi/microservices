package com.inventory.inventory;

import com.inventory.inventory.model.Inventory;
import com.inventory.inventory.repos.InventoryRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
public class InventoryApplication implements CommandLineRunner {
   private final InventoryRepo inventoryRepo;

	public InventoryApplication(InventoryRepo inventoryRepo) {
		this.inventoryRepo = inventoryRepo;
	}

	public static void main(String[] args) {
		SpringApplication.run(InventoryApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		var inventoryList = new ArrayList<>(List.of(
				new Inventory(100,"Iphon1"),
				new Inventory(100,"OPPO1"),
				new Inventory(100,"Galaxy")
		));
		inventoryRepo.saveAll(inventoryList);

	}
}
