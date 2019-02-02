package com.world.countries.controllers;

import com.world.countries.models.Country;
import com.world.countries.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/country")
public class CountryController {

    @Autowired
    private CountryRepository countryRepository;

    @GetMapping
    public List<Country> list(){
        return countryRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Country country){
        countryRepository.saveAndFlush(country);
    }

    @GetMapping("/{id}")
    public Country get(@PathVariable("id") long id){
        System.out.println(id);
        Country country = countryRepository.findById(id).orElse(new Country());
        return country;
    }
}
