package com.learning.mythology.repository;

import com.learning.mythology.model.God;
import com.learning.mythology.repository.util.GodRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GodRepositoryImpl implements GodRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public God createGod(God god) {
        jdbcTemplate.update("insert into gods (name, description) values (?,?)", god.getName(), god.getDescription());
        return god;
    }

    @Override
    public List<God> getGods() {
        List<God> gods = jdbcTemplate.query("select * from gods", new GodRowMapper());
        return gods;
    }

    @Override
    public God getGod(Integer id) {
        God god = jdbcTemplate.queryForObject("select * from gods where id = ?", new GodRowMapper(), id);
        return god;
    }

    @Override
    public God updateGod(God god) {
        jdbcTemplate.update("update gods set name = ?, description = ? where id = ?",
                god.getName(), god.getDescription(), god.getId());
        return god;
    }

}