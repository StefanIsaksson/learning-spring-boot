package com.learning.mythology.controller;

import com.learning.mythology.model.God;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class GodControllerIT {


    @Test(timeout = 5000)
    public void testGetGods() {
        RestTemplate restTemplate = new RestTemplate();

        final String URL = "http://localhost:8080/api/v1/gods";
        ResponseEntity<List<God>> godsResponse = restTemplate.exchange(
                URL, HttpMethod.GET,
                null, new ParameterizedTypeReference<List<God>>() {
                });
        List<God> gods = godsResponse.getBody();

        for (God god : gods) {
            System.out.println("Name: " + god.getName());
        }
    }

    @Test(timeout = 5000)
    public void testPutGods() {
        RestTemplate restTemplate = new RestTemplate();

        final String URL = "http://localhost:8080/api/v1/gods";
        God request = new God("Odin","King");
        God response = restTemplate.postForObject(URL, request, God.class);

        System.out.println("Name: " + response.getName());
    }

    @Test(timeout = 5000)
    public void testGetGod() {
        RestTemplate restTemplate = new RestTemplate();

        String URL = "http://localhost:8080/api/v1/gods/1";
        God response = restTemplate.getForObject(URL, God.class);

        System.out.println("Name: " + response.getName());
    }

    @Test(timeout = 5000)
    public void testUpdateGod() {
        RestTemplate restTemplate = new RestTemplate();

        God god = restTemplate.getForObject("http://localhost:8080/api/v1/gods/1", God.class);
        final String descriptionBeforeUpdate = god.getDescription();

        god.setDescription(descriptionBeforeUpdate + " :-) ");

        restTemplate.put("http://localhost:8080/api/v1/gods", god);
        God updatedGod = restTemplate.getForObject("http://localhost:8080/api/v1/gods/1", God.class);

        System.out.println("Description BEFORE update : " + descriptionBeforeUpdate);
        System.out.println("Description AFTER update : " + updatedGod.getDescription());
    }
}
