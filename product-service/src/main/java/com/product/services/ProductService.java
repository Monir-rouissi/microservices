package com.product.services;

import com.product.dto.ProductRequest;
import com.product.model.Product;
import com.product.repos.ProductRepo;
import com.product.dto.ProductResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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

    public Iterable<ProductResponse> findAll() {
        Iterable<Product> all = repository.findAll();
        return  StreamSupport.stream(all.spliterator(), false)
                .map(this::maptoResponse)
                .collect(Collectors.toList());

    }

    private ProductResponse maptoResponse(Product product) {
        return new ProductResponse(1,product.getName(), product.getPrice());
    }
}
