package com.dinoz.orderservice.repository.util;

import com.dinoz.orderservice.model.Order;
import com.dinoz.orderservice.model.OrderStatus;
import com.dinoz.orderservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderRowMapper implements RowMapper<Order> {

    @Override
    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
        Order order = new Order();
        order.setId(rs.getString("ID"));
        order.setCustomerId(rs.getString("CUSTOMER_ID"));
        order.setOrderStatus(OrderStatus.valueOf(rs.getString("ORDER_STATUS")));
        order.setShippingAddress(rs.getString("SHIPPING_ADDRESS"));
        return order;
    }
}
