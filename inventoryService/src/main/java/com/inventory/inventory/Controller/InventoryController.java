package com.inventory.inventory.Controller;

import com.inventory.inventory.model.Inventory;
import com.inventory.inventory.model.InventoryRequest;
import com.inventory.inventory.services.InventoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/inventory")
public class InventoryController {
    private final InventoryService service;

    public InventoryController(InventoryService service) {
        this.service = service;
    }
    @PostMapping("add")
    public ResponseEntity<Inventory> createProduct(@RequestBody InventoryRequest inventoryRequest) {
        return service.createInventory(inventoryRequest);
    }

    @GetMapping("/{sku-code}")
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock(@PathVariable(name = "sku-code") String skuCode)
    {
        return service.isInStock(skuCode);
    }
}
