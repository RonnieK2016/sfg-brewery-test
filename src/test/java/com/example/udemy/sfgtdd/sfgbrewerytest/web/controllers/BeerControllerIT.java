package com.example.udemy.sfgtdd.sfgbrewerytest.web.controllers;

import com.example.udemy.sfgtdd.sfgbrewerytest.web.model.BeerPagedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BeerControllerIT {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void listBeers() {
        BeerPagedList beerPagedList = restTemplate.getForObject("/api/v1/beer", BeerPagedList.class);

        assertEquals(3, beerPagedList.getContent().size());
    }
}