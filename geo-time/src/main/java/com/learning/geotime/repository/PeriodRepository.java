package com.learning.geotime.repository;

import com.learning.geotime.model.Epoch;
import com.learning.geotime.model.Period;

import java.util.List;

public interface PeriodRepository {

    List<Period> getPeriods();
}
