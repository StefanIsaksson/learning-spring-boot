package com.learning.geotime.repository.util;

import com.learning.geotime.model.Epoch;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EpochRowMapper implements RowMapper<Epoch> {

    @Override
    public Epoch mapRow(ResultSet rs, int rowNum) throws SQLException {
        Epoch epoch = new Epoch();
        epoch.setId(rs.getInt("id"));
        epoch.setName(rs.getString("name"));
        epoch.setDescription(rs.getString("description"));
        epoch.setPeriod(rs.getString("period"));
        epoch.setStart(rs.getBigDecimal("start"));
        epoch.setEnd(rs.getBigDecimal("end"));
        return epoch;
    }
}
