package com.team2.smarttowns.trail;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TrailRepositoryJDBC implements TrailRepository {
    private JdbcTemplate jdbc;
    private RowMapper<Trail> trailMapper; // an interface for mapping rows of a database result set to Java objects


    public TrailRepositoryJDBC(JdbcTemplate aJdbc) {
        this.jdbc = aJdbc;
        setTrailMapper();
    }

    private void setTrailMapper() {
        trailMapper = (rs, i) -> new Trail(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("image"),
                rs.getString("details")
        );
    }

    @Override
    public List<Trail> getAllTrails() {
        String sql = "select * from trail";
        return jdbc.query(sql, trailMapper);
    }
}

