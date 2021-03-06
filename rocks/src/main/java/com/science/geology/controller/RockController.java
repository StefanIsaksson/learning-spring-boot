package com.science.geology.controller;

import com.science.geology.repository.RockRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

import com.science.geology.model.Rock;

import static com.science.geology.util.ModelHelper.getNullPropertyNames;

@RestController
@RequestMapping("api/v1/")
public class RockController {

    @Autowired
    private RockRepository rockRepository;

    @RequestMapping(value = "rocks", method = RequestMethod.GET)
    public List<Rock> list() {
        return rockRepository.findAll( new Sort(Sort.Direction.ASC, "id"));
    }


    @RequestMapping(value = "rocks", method = RequestMethod.POST)
    public Rock create(@RequestBody Rock rock) {
        return rockRepository.saveAndFlush(rock);
    }

    @RequestMapping(value = "rocks/{id}", method = RequestMethod.GET)
    public Rock get(@PathVariable Long id) {
        Optional<Rock> optionalRock = rockRepository.findById(id);
        return optionalRock.orElse(null);
    }

    @RequestMapping(value = "rocks/{id}", method = RequestMethod.PUT)
    public Rock update(@PathVariable Long id, @RequestBody Rock rock) {
        Optional<Rock> optionalRock = rockRepository.findById(id);
        if(optionalRock.isPresent()){
            Rock existingRock = optionalRock.get();
            BeanUtils.copyProperties(rock, existingRock);
            existingRock.setId(id);
            return rockRepository.saveAndFlush(existingRock);
        } else {
            return null; //TODO: Return some error message saying rock not found.
        }
    }

    @RequestMapping(value = "rocks/{id}", method = RequestMethod.PATCH)
    public Rock patch(@PathVariable Long id, @RequestBody Rock rock) {
        Optional<Rock> optionalRock = rockRepository.findById(id);
        if(optionalRock.isPresent()){
            Rock existingRock = optionalRock.get();
            BeanUtils.copyProperties(rock, existingRock, getNullPropertyNames(rock));
            existingRock.setId(id);
            return rockRepository.saveAndFlush(existingRock);
        } else {
            return null; //TODO: Return some error message saying rock not found.
        }
    }

    @RequestMapping(value = "rocks/{id}", method = RequestMethod.DELETE)
    public Rock delete(@PathVariable Long id) {
        Optional<Rock> optionalRock = rockRepository.findById(id);
        if(optionalRock.isPresent()){
            Rock existingRock = optionalRock.get();
            rockRepository.delete(existingRock);
            return existingRock;
        } else {
            return null; //TODO: Return some error message saying rock not found.
        }
    }

}
