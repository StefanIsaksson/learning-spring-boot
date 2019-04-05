package com.dinoz.customerservice.repository;

import com.dinoz.customerservice.model.Customer;

import java.util.List;

public interface CustomerRepository {

    List<Customer> getCustomers();

    Customer createCustomer(Customer customer);

    Customer getCustomer(String id);

    Customer updateCustomer(Customer customer);

    void deleteCustomer(String id);
}
