package ir.omidashouri.marsroverapi.controllers;

import ir.omidashouri.marsroverapi.model.MarsRoverApiResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

class HomeControllerTest {

    RestTemplate restTemplate;

    @BeforeEach
    void setUp() {
        restTemplate = new RestTemplate();
    }

    @Test
    void getHomeView() {
    }

    @Test
    void testGetHomeView() {
        System.out.println("Hi there");
        ResponseEntity<MarsRoverApiResponse> responseEntity = restTemplate
                .getForEntity("https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=2&api_key=DEMO_KEY",MarsRoverApiResponse.class);

        System.out.println(responseEntity.getBody());
    }
}