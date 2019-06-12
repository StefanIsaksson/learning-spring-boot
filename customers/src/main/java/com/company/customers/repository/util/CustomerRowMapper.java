package com.company.customers.repository.util;

import com.company.customers.model.Customer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRowMapper implements RowMapper<Customer> {

    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Customer customer = new Customer();
        customer.setId(rs.getInt("id"));
        customer.setName(rs.getString("name"));
        customer.setCustomerId(rs.getString("customerId"));
        customer.setIncome(rs.getInt("income"));
        customer.setScore(rs.getBigDecimal("score"));
        customer.setPartnerName(rs.getString("partner_name"));
        return customer;
    }
}
