package com.company.platform.service;

import com.company.platform.model.Customer;
import com.company.platform.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer findCustomerById(String id) {
        return customerRepository.findById(id).orElse(null);
    }
}