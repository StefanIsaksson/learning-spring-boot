package com.learning.mythology.repository.util;

import com.learning.mythology.model.God;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GodRowMapper implements RowMapper<God> {

    @Override
    public God mapRow(ResultSet rs, int rowNum) throws SQLException {
        God god = new God();
        god.setId(rs.getInt("id"));
        god.setName(rs.getString("name"));
        god.setDescription(rs.getString("description"));
        return god;
    }
}
