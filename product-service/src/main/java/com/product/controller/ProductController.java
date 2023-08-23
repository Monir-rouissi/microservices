package com.product.controller;

import com.product.dto.ProductRequest;
import com.product.dto.ProductResponse;
import com.product.services.ProductService;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/products")
@RestController
public class ProductController {
    private ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping("add")
    public void createProduct(@RequestBody ProductRequest product) {
        service.createProduct(product);
    }

    @GetMapping
    public Iterable<ProductResponse> findAll() {

         return service.findAll();
    }
}
