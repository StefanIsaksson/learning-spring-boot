package com.dinoz.orderservice.service;

import com.dinoz.orderservice.model.Order;
import com.dinoz.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService
{

    @Autowired
    OrderRepository orderRepository;

    @Override
    public List<Order> getOrders() {
        return orderRepository.getOrders();
    }

    @Override
    public Order createOrder(Order order) {
        return orderRepository.createOrder(order);
    }

    @Override
    public Order getOrder(Long id) {
        return orderRepository.getOrder(id);
    }

    @Override
    public Order updateOrder(Order order) {
        return orderRepository.updateOrder(order);
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteOrder(id);
    }
}
