package com.dinoz.orderservice.repository;

import com.dinoz.orderservice.model.Order;

import java.util.List;

public interface OrderRepository {

    List<Order> getOrders();

    Order createOrder(Order order);

    Order getOrder(String id);

    Order updateOrder(Order order);

    void deleteOrder(String id);
}
