package com.dinoz.productservice.repository;

import com.dinoz.productservice.model.Product;
import com.dinoz.productservice.repository.util.ProductRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Repository
public class ProductRepositoryImpl implements ProductRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Product> getProducts() {
        List<Product> products = jdbcTemplate.query("select * from products", new ProductRowMapper());
        return products;
    }

    @Override
    public Product createProduct(Product product) {
        jdbcTemplate.update("insert into products (id, name, description, price) values (?,?,?,?)", product.getId(), product.getName(), product.getDescription(), product.getPrice());
        return product;
    }

    @Override
    public Product getProduct(String id) {
        List<Product> product = jdbcTemplate.query("select * from products where id = ?", new ProductRowMapper(), id);
        return !product.isEmpty() ? product.get(0) : null;
    }

    @Override
    public Product updateProduct(Product product) {
        jdbcTemplate.update("update products set name = ?, description = ?, price = ? where id = ?",
                product.getName(), product.getDescription(), product.getPrice(), product.getId());
        return product;
    }

    @Override
    public void deleteProduct(String id) {
        jdbcTemplate.update("delete from products where id = ?", id);
    }
}
