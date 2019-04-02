package com.dinoz.orderservice.repository;

import com.dinoz.orderservice.model.Order;
import com.dinoz.orderservice.model.Product;

import java.util.List;

public interface ProductRepository {

    List<Product> getProducts(Order order);
}
