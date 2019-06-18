package com.company.customers.repository.util;

import com.company.customers.model.Customer;
import org.springframework.jdbc.core.RowMapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRowMapper implements RowMapper<Customer> {

    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Customer customer = new Customer();
        customer.setId(rs.getInt("id"));
        customer.setName(rs.getString("name"));
        customer.setCustomerId(rs.getString("customerId"));
        Integer annualIncome = rs.getInt("income");
        customer.setIncome(annualIncome / 12);
        customer.setScore(rs.getBigDecimal("score"));
        customer.setPartnerName(rs.getString("partner_name"));
        customer.setMaritalStatus(rs.getString("marital_status"));
        customer.setAddress(rs.getString("address"));
        customer.setLastUpdated(rs.getDate("last_updated"));
        return customer;
    }
}
