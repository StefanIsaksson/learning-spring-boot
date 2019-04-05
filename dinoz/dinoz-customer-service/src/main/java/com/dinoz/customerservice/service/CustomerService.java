package com.dinoz.customerservice.service;

import com.dinoz.customerservice.model.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getCustomers();

    Customer getCustomer(String id);

    Customer saveCustomer(Customer product);

    void deleteCustomer(String id);
}
