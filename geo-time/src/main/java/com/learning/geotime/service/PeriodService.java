package com.learning.geotime.service;

import com.learning.geotime.model.Period;

import java.util.List;

public interface PeriodService {

    List<Period> getPeriods();

    List<String> getPeriodNames();

}
