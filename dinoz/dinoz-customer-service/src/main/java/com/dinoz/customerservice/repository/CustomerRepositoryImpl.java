package com.dinoz.customerservice.repository;

import com.dinoz.customerservice.model.Customer;
import com.dinoz.customerservice.repository.util.CustomerRowMapper;
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
        List<Customer> customers = jdbcTemplate.query("select * from customers", new CustomerRowMapper());
        return customers;
    }

    @Override
    public Customer createCustomer(Customer customer) {
        jdbcTemplate.update("insert into customers (id, name, address, phone) values (?,?,?,?)", customer.getId(), customer.getName(),customer.getAddress(), customer.getPhone());
        return customer;
    }

    @Override
    public Customer getCustomer(String id) {
        List<Customer> customers = jdbcTemplate.query("select * from customers where id = ?", new CustomerRowMapper(), id);
        return !customers.isEmpty() ? customers.get(0) : null;
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        jdbcTemplate.update("update customers set name = ?, address =?, phone = ? where id = ?",
                customer.getName(), customer.getAddress(), customer.getPhone(), customer.getId());
        return customer;
    }

    @Override
    public void deleteCustomer(String id) {
        jdbcTemplate.update("delete from customers where id = ?", id);
    }
}
