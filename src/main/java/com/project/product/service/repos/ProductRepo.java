package com.project.product.service.repos;

import com.project.product.service.model.Product;
import org.springframework.data.repository.CrudRepository;


public interface ProductRepo extends CrudRepository<Product,Integer> {
}
