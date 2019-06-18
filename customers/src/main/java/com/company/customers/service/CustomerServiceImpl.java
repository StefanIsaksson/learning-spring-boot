package com.company.customers.service;

import com.company.customers.model.Customer;
import com.company.customers.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService
{

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> getCustomers() {
        return calculateAge(calculateGender(customerRepository.getCustomers()));
    }

    @Override
    public List<Customer> getCustomers(String searchQuery) {
        return calculateAge(calculateGender(customerRepository.getCustomers(searchQuery)));
    }

    private List<Customer> calculateAge(List<Customer> customers) {
        return customers.stream().map(customer -> calculateAge(customer)).collect(Collectors.toList());
    }

    private Customer calculateAge(Customer customer) {
        String birthDayString = customer.getCustomerId().substring(0, 8);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd", Locale.ENGLISH);
        LocalDate birthDay = LocalDate.parse(birthDayString, formatter);

        LocalDate now = LocalDate.now();
        Period period = Period.between(birthDay, now);
        int age = period.getYears();

        customer.setAge(age);
        return customer;
    }

    private List<Customer> calculateGender(List<Customer> customers) {
        return customers.stream().map(customer -> calculateGender(customer)).collect(Collectors.toList());
    }

    private Customer calculateGender(Customer customer) {
        String genderControlNumber = customer.getCustomerId().substring(customer.getCustomerId().length() - 2, customer.getCustomerId().length() - 1);
        Integer customerId = Integer.valueOf(genderControlNumber);
        if(customerId % 2 == 0){
            customer.setGender("Female");
        } else {
            customer.setGender("Male");
        }
        return customer;
    }



}
