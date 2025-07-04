package com.company.platform.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.company.platform.model.Customer;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {
    // Method to find a customer by ID
    Optional<Customer> findById(String id);
}