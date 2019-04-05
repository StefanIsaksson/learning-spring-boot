package com.dinoz.customerservice.service;

import com.dinoz.customerservice.model.Customer;
import com.dinoz.customerservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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
    public Customer getCustomer(String id) {
        return customerRepository.getCustomer(id);
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        if(customer.getId() == null){
            customer.setId(UUID.randomUUID().toString());
            customerRepository.createCustomer(customer);
            return customer;
        }
        Customer existingProduct = customerRepository.getCustomer(customer.getId());
        if(existingProduct != null) {
            customerRepository.updateCustomer(customer);
        } else {
            customerRepository.createCustomer(customer);
        }
        return customer;
    }

    @Override
    public void deleteCustomer(String id) {
        customerRepository.deleteCustomer(id);
    }
}
