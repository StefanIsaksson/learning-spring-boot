package com.learning.geotime.controller;

import com.learning.geotime.model.Epoch;
import com.learning.geotime.model.Period;
import com.learning.geotime.service.PeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PeriodController {

    @Autowired
    PeriodService periodService;

    @RequestMapping(value = "/api/v1/periods", method = RequestMethod.GET)
    public @ResponseBody
    List<Period> getPeriods() {
        return periodService.getPeriods();
    }
}
