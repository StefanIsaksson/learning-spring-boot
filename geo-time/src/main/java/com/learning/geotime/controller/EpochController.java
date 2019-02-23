package com.learning.geotime.controller;

import com.learning.geotime.model.Epoch;
import com.learning.geotime.service.EpochService;
import com.learning.geotime.service.PeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class EpochController {

    @Autowired
    EpochService epochService;

    @Autowired
    PeriodService periodService;

    @PostMapping("/addEpoch")
    public String addEpoch(Map<String, Object> model, @ModelAttribute("epoch") Epoch epoch) {
        List<String> periodsNames = periodService.getPeriodNames();
        model.put("availablePeriods", periodsNames);
        if (epoch.getName() != null) {
            epochService.createEpoch(epoch);
            return "redirect:/";
        }
        return "addEpoch";
    }

    @GetMapping("/addEpoch")
    public String getEpoch(Map<String, Object> model, @ModelAttribute("epoch") Epoch epoch) {
        List<String> periodsNames = periodService.getPeriodNames();
        model.put("availablePeriods", periodsNames);
        return "addEpoch";
    }

    @RequestMapping("/")
    public String listEpoch(Map<String, Object> model, @ModelAttribute("epoch") Epoch epoch) {
        List<Epoch> epochs = epochService.getEpochs();
        model.put("epochs", epochs);
        return "listEpoch";
    }

    @RequestMapping(value = "/api/v1/epochs", method = RequestMethod.GET)
    public @ResponseBody
    List<Epoch> getEpochs() {
        return epochService.getEpochs();
    }
}
