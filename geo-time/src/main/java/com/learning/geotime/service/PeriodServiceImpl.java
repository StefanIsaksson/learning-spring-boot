package com.learning.geotime.service;

import com.learning.geotime.model.Epoch;
import com.learning.geotime.model.Period;
import com.learning.geotime.repository.EpochRepository;
import com.learning.geotime.repository.PeriodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PeriodServiceImpl implements PeriodService {

    @Autowired
    PeriodRepository periodRepository;

    @Override
    public List<Period> getPeriods() {
        return periodRepository.getPeriods();
    }

    @Override
    public List<String> getPeriodNames() {
        List<Period> periods = periodRepository.getPeriods();
        return periods.stream().map(Period::getName).collect(Collectors.toList());
    }
}
