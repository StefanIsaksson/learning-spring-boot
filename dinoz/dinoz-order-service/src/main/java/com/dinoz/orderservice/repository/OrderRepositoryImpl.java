package com.dinoz.orderservice.repository;

import com.dinoz.orderservice.model.Order;
import com.dinoz.orderservice.model.OrderStatus;
import com.dinoz.orderservice.model.Product;
import com.dinoz.orderservice.repository.util.OrderRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Order> getOrders() {
        List<Order> orders = jdbcTemplate.query("select * from orders", new OrderRowMapper());
        for(Order order : orders){
            order.setProducts(productRepository.getProducts(order));
        }
        return orders;
    }

    @Override
    public Order createOrder(Order order) {
        return null;
    }

    @Override
    public Order getOrder(String id) {
        return null;
    }

    @Override
    public Order updateOrder(Order order) {
        return null;
    }

    @Override
    public void deleteOrder(String id) {

    }

}
