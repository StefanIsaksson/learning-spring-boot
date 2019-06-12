package com.company.customers.controllers;

import com.company.customers.model.Customer;
import com.company.customers.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("")
    public List<Customer> getCustomers(@RequestParam("name") String name) {
        if(name == null || name.isEmpty()){
            return customerService.getCustomers();
        } else {
            return customerService.getCustomers(name);
        }
    }
}
