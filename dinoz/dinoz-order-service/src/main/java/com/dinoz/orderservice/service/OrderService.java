package com.dinoz.orderservice.service;

import com.dinoz.orderservice.model.Order;

import java.util.List;

public interface OrderService {

    List<Order> getOrders();

    Order createOrder(Order order);

    Order getOrder(Long id);

    Order updateOrder(Order order);

    void deleteOrder(Long id);
}
