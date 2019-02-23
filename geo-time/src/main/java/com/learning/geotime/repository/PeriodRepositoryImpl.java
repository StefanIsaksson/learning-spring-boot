package com.learning.geotime.repository;

import com.learning.geotime.model.Epoch;
import com.learning.geotime.model.Period;
import com.learning.geotime.repository.util.EpochRowMapper;
import com.learning.geotime.repository.util.PeriodRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PeriodRepositoryImpl implements PeriodRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Period> getPeriods() {
        List<Period> periods = jdbcTemplate.query("select p.id, p.name, p.description from period p", new PeriodRowMapper());
        return periods;
    }
}
