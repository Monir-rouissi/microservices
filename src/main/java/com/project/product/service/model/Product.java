package com.project.product.service.model;


import jakarta.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String price;

    public Product() {
    }

    public Product(Integer id, String name, String price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }


}
