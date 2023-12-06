package com.team2.smarttowns.checkpoint;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CheckpointRepositoryJDBC implements CheckpointRepository {
    private JdbcTemplate jdbc;
    private RowMapper<Checkpoint> checkpointMapper; // an interface for mapping rows of a database result set to Java objects


    public CheckpointRepositoryJDBC(JdbcTemplate aJdbc) {
        this.jdbc = aJdbc;
        setCheckpointMapper();
    }

    private void setCheckpointMapper() {
        checkpointMapper = (rs, i) -> new Checkpoint(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("img"),
                rs.getString("description"),
                rs.getString("contact")
        );
    }

    @Override
    public List<Checkpoint> getAll() {
        String sql = "select * from checkpoint";
        return jdbc.query(sql, checkpointMapper);
    }
}
