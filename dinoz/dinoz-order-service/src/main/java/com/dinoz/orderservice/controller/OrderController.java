package com.dinoz.orderservice.controller;

import com.dinoz.orderservice.model.Order;
import com.dinoz.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("")
    public List<Order> findAllProducts() {
        return orderService.getOrders();
    }

    @GetMapping("/{orderId}")
    public Order findBook(@PathVariable Long orderId) {
        return orderService.getOrder(orderId);
    }

}
