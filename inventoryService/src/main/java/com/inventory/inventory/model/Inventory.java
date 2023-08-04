package com.inventory.inventory.model;

import jakarta.persistence.*;

@Entity
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Inventory(Integer quantity, String skuCode) {
        Quantity = quantity;
        this.skuCode = skuCode;
    }

    private Integer Quantity;

    private String skuCode;

    public Inventory() {
    }

    public Inventory(Long id, String skuCode) {
        this.id = id;
        this.skuCode = skuCode;
    }

    public Integer getQuantity() {
        return Quantity;
    }

    public void setQuantity(Integer quantity) {
        Quantity = quantity;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }
}
