package com.dinoz.orderservice.repository.util;

import com.dinoz.orderservice.model.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<Product> {

    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        Product product = new Product();
        product.setId(rs.getString("ID"));
        product.setProductName(rs.getString("NAME"));
        product.setPrice(rs.getBigDecimal("PRICE"));
        return product;
    }
}
