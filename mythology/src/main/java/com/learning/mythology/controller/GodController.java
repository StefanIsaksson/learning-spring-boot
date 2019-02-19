package com.learning.mythology.controller;

import com.learning.mythology.model.God;
import com.learning.mythology.service.GodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class GodController {

    public static final String GODS_PATH = "/api/v1/gods";
    @Autowired
    private GodService godService;

    @RequestMapping(value = GODS_PATH, method = RequestMethod.POST)
    public @ResponseBody God createGod(@RequestBody God god){
        return godService.createGod(god);
    }

    @RequestMapping(value = GODS_PATH, method = RequestMethod.GET)
    public @ResponseBody
    List<God> getGods(){
        return godService.getGods();
    }
}
