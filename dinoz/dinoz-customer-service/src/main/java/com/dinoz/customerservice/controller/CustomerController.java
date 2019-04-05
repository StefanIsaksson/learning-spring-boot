package com.dinoz.customerservice.controller;

import com.dinoz.customerservice.model.Customer;
import com.dinoz.customerservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("")
    public List<Customer> findAllProducts() {
        return customerService.getCustomers();
    }

    @GetMapping("/{id}")
    public Customer findCustomer(@PathVariable String id) {
        return customerService.getCustomer(id);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public @ResponseBody Customer updateCustomer(@RequestBody Customer customer){
        return customerService.saveCustomer(customer);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public @ResponseBody Object deleteCustomer(@PathVariable(value = "id") String id){
        customerService.deleteCustomer(id);
        return null;
    }

}
