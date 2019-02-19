package com.learning.mythology.controller;

import com.learning.mythology.model.God;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class GodControllerIT {

    public static final String GODS_URL = "http://localhost:8080/api/v1/gods";

    @Test(timeout = 5000)
    public void getGodsTest() {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<List<God>> godsResponse = restTemplate.exchange(
                GODS_URL, HttpMethod.GET,
                null, new ParameterizedTypeReference<List<God>>() {
                });
        List<God> gods = godsResponse.getBody();

        for (God god : gods) {
            System.out.println("Name: " + god.getName());
        }
    }

    @Test(timeout = 5000)
    public void putGodsTest() {
        RestTemplate restTemplate = new RestTemplate();

        God request = new God("Odin","King");
        God response = restTemplate.postForObject(GODS_URL, request, God.class);
        System.out.println("Name: " + response.getName());
    }

}
