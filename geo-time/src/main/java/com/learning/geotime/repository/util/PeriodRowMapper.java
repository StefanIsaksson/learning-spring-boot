package com.learning.geotime.repository.util;

import com.learning.geotime.model.Period;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PeriodRowMapper implements RowMapper<Period> {

    @Override
    public Period mapRow(ResultSet rs, int rowNum) throws SQLException {
        Period period = new Period();
        period.setId(rs.getInt("id"));
        period.setName(rs.getString("name"));
        period.setDescription(rs.getString("description"));
        return period;
    }
}
