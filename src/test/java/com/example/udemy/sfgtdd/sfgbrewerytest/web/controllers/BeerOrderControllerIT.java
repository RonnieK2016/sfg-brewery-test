package com.example.udemy.sfgtdd.sfgbrewerytest.web.controllers;

import com.example.udemy.sfgtdd.sfgbrewerytest.domain.Customer;
import com.example.udemy.sfgtdd.sfgbrewerytest.repositories.CustomerRepository;
import com.example.udemy.sfgtdd.sfgbrewerytest.web.model.BeerOrderPagedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BeerOrderControllerIT {

    @Autowired
    TestRestTemplate restTemplate;

    @Autowired
    private CustomerRepository repository;

    private Customer customer;


    @BeforeEach
    void setUp() {
        customer = repository.findAll().get(0);
    }

    @Test
    void listOrders() {
        BeerOrderPagedList beerOrderPagedList = restTemplate
                .getForObject("/api/v1/customers/"+ customer.getId() +"/orders/", BeerOrderPagedList.class);
        assertThat(beerOrderPagedList.getContent()).hasSize(1);
    }
}