package com.dinoz.orderservice.model;

public class Product {
    private Long id;
    private Long price;

    public Product(Long id, Long price) {
        this.id = id;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
