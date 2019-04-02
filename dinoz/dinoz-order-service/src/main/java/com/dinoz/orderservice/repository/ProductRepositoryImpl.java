package com.dinoz.orderservice.repository;

import com.dinoz.orderservice.model.Order;
import com.dinoz.orderservice.model.Product;
import com.dinoz.orderservice.repository.util.OrderRowMapper;
import com.dinoz.orderservice.repository.util.ProductRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Product> getProducts(Order order) {
        List<Product> products = jdbcTemplate.query("select * from products where fk_orders = ?", new ProductRowMapper(), order.getId());
        return products != null ? products : new ArrayList<>();
    }

}
