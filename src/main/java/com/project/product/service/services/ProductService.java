package com.project.product.service.services;

import com.project.product.service.dto.ProductRequest;
import com.project.product.service.model.Product;
import com.project.product.service.repos.ProductRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private  final ProductRepo repository;

    public ProductService(ProductRepo repository) {
        this.repository = repository;
    }

    public ResponseEntity<Product> createProduct(ProductRequest product) {
        var productDB = new Product(product.id(), product.name(),product.price());
        repository.save(productDB);
        return  ResponseEntity.ok().build();
    }

    public Iterable<Product> findAll() {
        return repository.findAll();
    }
}
