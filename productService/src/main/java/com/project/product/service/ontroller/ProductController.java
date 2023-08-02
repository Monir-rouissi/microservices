package com.project.product.service.ontroller;

import com.project.product.service.dto.ProductRequest;
import com.project.product.service.model.Product;
import com.project.product.service.services.ProductService;
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
    public Iterable<Product> findAll() {
        return service.findAll();
    }
}
