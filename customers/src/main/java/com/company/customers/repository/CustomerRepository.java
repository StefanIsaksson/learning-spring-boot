package com.company.customers.repository;

import com.company.customers.model.Customer;

import java.util.List;

public interface CustomerRepository {

    List<Customer> getCustomers();

    List<Customer> getCustomers(String searchQuery);
}
