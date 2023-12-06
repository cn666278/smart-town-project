package com.team2.smarttowns.dao;

import com.team2.smarttowns.entity.CheckpointEntity;
import com.team2.smarttowns.entity.TrailEntity;
import com.team2.smarttowns.model.Trail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

import static java.sql.DriverManager.getConnection;

/**
 * TrailRepository reads data from the database and returns the data to the controller.
 *
 * @version 1.0
 *
 * @author CHENKE SUN
 *
 *
 */

@Repository
public class TrailRepositoryImpl implements TrailRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<TrailEntity> trailRowMapper = (rs, rowNum) -> {
        TrailEntity trail = new TrailEntity();
        trail.setId(rs.getInt("id"));
        trail.setName(rs.getString("name"));
        trail.setImage(rs.getString("image"));
        trail.setDetails(rs.getString("details"));
        return trail;
    };

    private RowMapper<TrailEntity> userRowMapper;
    private RowMapper<CheckpointEntity> checkpointRowMapper;

    public List<TrailEntity> getAllTrails() {
        String sql = "SELECT * FROM trails";
        return jdbcTemplate.query(sql, trailRowMapper);
    }

    public List<CheckpointEntity> getCheckpointsById(int id) {
        //todo rename checkpoints to trail_checkpoint
        List<CheckpointEntity> checkpoints = new ArrayList<>();
        String sql = "SELECT c.* FROM checkpoints c " +
                "INNER JOIN trail_checkpoint tc ON c.id = tc.checkpoint_id " +
                "WHERE tc.trail_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    CheckpointEntity checkpoint = new CheckpointEntity();
                    checkpoint.setId(rs.getInt("id"));
                    checkpoint.setLatitude(rs.getString("latitude"));
                    checkpoint.setLongitude(rs.getString("longitude"));
                    checkpoint.setName(rs.getString("name"));
                    checkpoint.setImage(rs.getString("image"));
                    checkpoint.setDetail(rs.getString("detail"));
                    checkpoint.setAddress(rs.getString("address"));
                    checkpoints.add(checkpoint);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return checkpoints;
    }
    private Connection getConnection() throws SQLException {
        return jdbcTemplate.getDataSource().getConnection();
    }

//    @Override
//    public void addTrail(TrailEntity trailEntity) {
//        String sql = "INSERT INTO trails (id,name,detail) VALUES (?,?,?)";
//        jdbcTemplate.update(sql, trailEntity.getId(), trailEntity.getName(), trailEntity.getDetail());
//    }


    public TrailRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public TrailRepositoryImpl() {
    }
}
