package com.learning.geotime.repository;

import com.learning.geotime.model.Epoch;
import com.learning.geotime.repository.util.EpochRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EpochRepositoryImpl implements EpochRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void createEpoch(Epoch epoch) {
        Integer periodId = jdbcTemplate.queryForObject("select id from period where name = ?", Integer.class, epoch.getPeriod());
        jdbcTemplate.update("insert into epoch (name, description, fk_period, start, end) values (?,?,?,?,?)", epoch.getName(), epoch.getDescription(), periodId, epoch.getStart(), epoch.getEnd());
    }

    @Override
    public List<Epoch> getEpochs() {
        List<Epoch> epochs = jdbcTemplate.query("select e.id, e.name, e.description, p.name period, e.start, e.end from epoch e join period p on e.fk_period = p.id", new EpochRowMapper());
        return epochs;
    }
}
