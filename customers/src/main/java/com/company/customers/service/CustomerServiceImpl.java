package com.company.customers.service;

import com.company.customers.model.Customer;
import com.company.customers.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService
{

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> getCustomers() {
        return customerRepository.getCustomers();
    }

    @Override
    public List<Customer> getCustomers(String name) {
        return customerRepository.getCustomers(name);
    }

}
