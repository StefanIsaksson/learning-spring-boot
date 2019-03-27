package com.dinoz.orderservice.repository;

import com.dinoz.orderservice.model.Order;
import com.dinoz.orderservice.model.OrderStatus;
import com.dinoz.orderservice.model.Product;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

    private List<Order> orders = Arrays.asList(
            new Order(1L, "1", "Sweden", OrderStatus.SHIPPED, Arrays.asList(new Product(1L, 500L))),
            new Order(2L, "1", "Norway", OrderStatus.PROCESSING, Arrays.asList(new Product(2L, 1500L)))
    );

    @Override
    public List<Order> getOrders() {
        return orders;
    }

    @Override
    public Order createOrder(Order order) {
        orders.add(order);
        return order;
    }

    @Override
    public Order getOrder(Long id) {
        return orders.stream().filter(b -> b.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public Order updateOrder(Order order) {
        Order existingOrder = getOrder(order.getId());
        if (orders.remove(existingOrder)) {
            orders.add(order);
            return order;
        }
        return null;
    }

    @Override
    public void deleteOrder(Long id) {
        Order existingOrder = getOrder(id);
        orders.remove(existingOrder);
    }
}
