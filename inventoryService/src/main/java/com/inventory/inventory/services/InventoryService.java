package com.inventory.inventory.services;

import com.inventory.inventory.model.Inventory;
import com.inventory.inventory.model.InventoryRequest;
import com.inventory.inventory.repos.InventoryRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

public class InventoryService {
    private InventoryRepo repo;

    public InventoryService(InventoryRepo repo) {
        this.repo = repo;
    }

    public ResponseEntity<Inventory> createInventory(InventoryRequest inventoryRequest) {
        Inventory inventory =  new Inventory(inventoryRequest.id(),inventoryRequest.skuCode());
        this.repo.save(inventory);
        return ResponseEntity.accepted().build();
    }
   // transactional impeorve performance
    @Transactional(readOnly = true)
    // This method can read data from the database, but not modify it.
    public Boolean isInStock(String skuCode) {
        return repo.findBySkuCode(skuCode).isPresent();
    }
}
