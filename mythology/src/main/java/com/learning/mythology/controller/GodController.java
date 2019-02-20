package com.learning.mythology.controller;

import com.learning.mythology.model.God;
import com.learning.mythology.service.GodService;
import com.learning.mythology.util.ServiceError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class GodController {

    @Autowired
    private GodService godService;

    @RequestMapping(value = "/api/v1/gods", method = RequestMethod.POST)
    public @ResponseBody God createGod(@RequestBody God god){
        return godService.createGod(god);
    }

    @RequestMapping(value = "/api/v1/gods", method = RequestMethod.GET)
    public @ResponseBody List<God> getGods(){
        return godService.getGods();
    }

    @RequestMapping(value = "/api/v1/gods/{id}", method = RequestMethod.GET)
    public @ResponseBody God getGod(@PathVariable(value = "id") Integer id){
        return godService.getGod(id);
    }

    @RequestMapping(value = "/api/v1/gods", method = RequestMethod.PUT)
    public @ResponseBody God updateGod(@RequestBody God god){
        return godService.updateGod(god);
    }


    @RequestMapping(value = "/api/v1/gods/{id}", method = RequestMethod.DELETE)
    public @ResponseBody Object deleteGod(@PathVariable(value = "id") Integer id){
        godService.deleteGod(id);
        return null;
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ServiceError> handle(RuntimeException e){
        ServiceError serviceError = new ServiceError(HttpStatus.OK.value(), e.getMessage());
        return new ResponseEntity<>(serviceError,HttpStatus.OK);
    }
}
