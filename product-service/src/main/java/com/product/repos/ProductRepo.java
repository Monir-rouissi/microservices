package com.product.repos;

import com.product.model.Product;
import org.springframework.data.repository.CrudRepository;


public interface ProductRepo extends CrudRepository<Product,Integer> {
}
