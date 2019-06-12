package com.company.customers.repository;

import com.company.customers.model.Customer;
import com.company.customers.repository.util.CustomerRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Customer> getCustomers() {
        List<Customer> customers = jdbcTemplate.query("select top 5 * from customers order by RAND()", new CustomerRowMapper());
        return customers;
    }

    @Override
    public List<Customer> getCustomers(String name) {
        List<Customer> customers = jdbcTemplate.query("select top 5 * from customers where LOWER(name) like ? order by RAND()", new CustomerRowMapper(), "%" + name.toLowerCase() + "%");
        return customers;
    }

}
