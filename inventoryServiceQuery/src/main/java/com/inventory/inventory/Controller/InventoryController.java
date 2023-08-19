package com.inventory.inventory.Controller;

import com.inventory.inventory.model.Inventory;
import com.inventory.inventory.model.InventoryRequest;
import com.inventory.inventory.model.InventoryResponse;
import com.inventory.inventory.services.InventoryService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> isInStock(@RequestParam List<String> skuCode)
    {
        return service.isInStock(skuCode);
    }
}
