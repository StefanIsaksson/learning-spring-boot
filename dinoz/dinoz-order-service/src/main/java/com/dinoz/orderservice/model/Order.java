package com.dinoz.orderservice.model;

import java.util.List;

public class Order {
    private Long id;
    private String customerId;
    private String shippingAdress;
    private OrderStatus orderStatus;
    private List<Product> products;

    public Order(Long id, String customerId, String shippingAdress, OrderStatus orderStatus, List<Product> products) {
        this.id = id;
        this.customerId = customerId;
        this.shippingAdress = shippingAdress;
        this.orderStatus = orderStatus;
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getShippingAdress() {
        return shippingAdress;
    }

    public void setShippingAdress(String shippingAdress) {
        this.shippingAdress = shippingAdress;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
