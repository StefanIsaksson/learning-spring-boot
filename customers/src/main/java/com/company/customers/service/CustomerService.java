package com.company.customers.service;

import com.company.customers.model.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getCustomers();

    List<Customer> getCustomers(String name);

}
