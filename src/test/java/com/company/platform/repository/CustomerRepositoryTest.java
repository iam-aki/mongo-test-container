package com.company.platform.repository;

import com.company.platform.model.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.assertj.core.api.Assertions.assertThat;

@Testcontainers
@DataMongoTest
public class CustomerRepositoryTest {

    @Container
    static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:7.0.5");

    @DynamicPropertySource
    static void setProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
    }

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    void testSaveAndFindCustomer() {
        Customer customer = new Customer();
        customer.setId("123");
        customer.setName("Test User");
        customerRepository.save(customer);

        Customer found = customerRepository.findById("123").orElse(null);
        assertThat(found).isNotNull();
        assertThat(found.getName()).isEqualTo("Test User");
    }
}
