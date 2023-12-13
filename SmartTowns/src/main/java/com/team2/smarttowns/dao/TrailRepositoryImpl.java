package com.team2.smarttowns.dao;

import com.team2.smarttowns.entity.CheckpointEntity;
import com.team2.smarttowns.entity.TrailEntity;
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

/**
 * TrailRepository reads data from the database and returns the data to the controller.
 *
 * @author CHENKE SUN
 * @version 1.0
 */

@Repository
public class TrailRepositoryImpl implements TrailRepository {

    private JdbcTemplate jdbcTemplate;

    private RowMapper<TrailEntity> trailRowMapper = (rs, rowNum) -> {
        TrailEntity trail = new TrailEntity();
        trail.setId(rs.getInt("id"));
        trail.setName(rs.getString("name"));
        trail.setImage(rs.getString("image"));
        trail.setDetails(rs.getString("detail"));
        return trail;
    };

    private RowMapper<TrailEntity> userRowMapper= (rs, rowNum) -> {
        TrailEntity trail = new TrailEntity();
        trail.setId(rs.getInt("id"));
        trail.setName(rs.getString("name"));
        trail.setImage(rs.getString("image"));
        trail.setDetails(rs.getString("details"));
        return trail;
    };
    private RowMapper<CheckpointEntity> checkpointRowMapper= (rs, rowNum) -> {
        CheckpointEntity checkpoint = new CheckpointEntity();
        checkpoint.setId(rs.getInt("id"));
        checkpoint.setName(rs.getString("name"));
        checkpoint.setImage(rs.getString("img"));
        checkpoint.setDescription(rs.getString("description"));
        checkpoint.setContact(rs.getString("contact"));
        checkpoint.setLatitude(rs.getString("latitude"));
        checkpoint.setLongitude(rs.getString("longitude"));
        checkpoint.setAddress(rs.getString("address"));
        return checkpoint;
    };

    @Override
    public List<TrailEntity> getAllTrails() {
        String sql = "SELECT * FROM trail";
        return jdbcTemplate.query(sql, trailRowMapper);
    }

    /**
     * Get all checkpoints of a trail by trail id
     * @param id
     * @return
     */
    @Override
    public List<CheckpointEntity> getCheckpointsByTrailId(int id) {
        //todo rename checkpoints to trail_checkpoint
        List<CheckpointEntity> checkpoints = new ArrayList<>();
        String sql = "SELECT c.* FROM checkpoint c " +
                "INNER JOIN trail_checkpoint tc ON c.id = tc.checkpoint_id " +
                "WHERE tc.trail_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    CheckpointEntity checkpoint = new CheckpointEntity();
                    checkpoint.setId(rs.getInt("id"));
                    checkpoint.setName(rs.getString("name"));
                    checkpoint.setImage(rs.getString("image"));
                    checkpoint.setDescription(rs.getString("description"));
                    checkpoint.setContact(rs.getString("contact"));
                    checkpoint.setLatitude(rs.getString("latitude"));
                    checkpoint.setLongitude(rs.getString("longitude"));
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


    @Autowired
    public TrailRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public void getTrailIdByCheckPointId(int checkpointEntityId) {
    }

    /**
     * get user trails by the checkpoints user visited
     *
     * @param UserId user id
     */
    @Override
    public List<Integer> getTrailsByUserId(int UserId) {
        // get user checkpoints by user id
        List<CheckpointEntity> checkpointEntities = getCheckpointsByUserId(UserId);

        // get a return list of trail id
        List<Integer> trailIds = new ArrayList<>();
        // save the trail id for each checkpoint
        for (CheckpointEntity checkpointEntity : checkpointEntities) {
            int checkpointEntityId = checkpointEntity.getId();
            // get trail by checkpoint id
            int trailId = getTrailIdByCheckpointId(checkpointEntityId);
            trailIds.add(trailId);
        }

        return trailIds;
    }

    @Override
    public List<Integer> getCompletedTrailsByUserId(int UserId) {
        // get user checkpoints by user id
        List<CheckpointEntity> checkpointEntities = getCheckpointsByUserId(UserId);

        // get a return list of trail id
        List<Integer> trailIds = new ArrayList<>();
        for (CheckpointEntity checkpointEntity : checkpointEntities) {
            int checkpointEntityId = checkpointEntity.getId();
            // get trail by trail id
            int trailId = getTrailIdByCheckpointId(checkpointEntityId);
            trailIds.add(trailId);
        }

        List<Integer> userCheckpoint = new ArrayList<>();
        for (CheckpointEntity checkpointEntity : checkpointEntities) {
            userCheckpoint.add(checkpointEntity.getId());
        }

        List<Integer> completedTrails = new ArrayList<>();
        // save the trail id user as completed
        for (int trailId : trailIds) {
            if (isCompleted(userCheckpoint, trailId)) {
                completedTrails.add(trailId);
            }
        }

        return completedTrails;
    }

    @Override
    public List<CheckpointEntity> getCheckpointsByUserId(int userId) {
        List<CheckpointEntity> checkpointEntities = new ArrayList<>();
        String sql = "SELECT c.* FROM checkpoint c " +
                "INNER JOIN user_checkpoint uc ON c.id = uc.checkpoint_id " +
                "WHERE uc.user_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, userId);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    CheckpointEntity checkpoint = new CheckpointEntity();
                    checkpoint.setId(rs.getInt("id"));
                    checkpoint.setLatitude(rs.getString("latitude"));
                    checkpoint.setLongitude(rs.getString("longitude"));
                    checkpoint.setName(rs.getString("name"));
                    checkpoint.setImage(rs.getString("image"));
                    checkpoint.setDescription(rs.getString("description"));
                    checkpoint.setAddress(rs.getString("address"));
                    checkpointEntities.add(checkpoint);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return checkpointEntities;
    }


    //from checkpoints id to find trail id
    public int getTrailIdByCheckpointId(int checkpointId) {
        String sql = "SELECT trail_id FROM trail_checkpoint WHERE checkpoint_id = ?";
        // notnull
        int trailIds = jdbcTemplate.queryForObject(sql,
                Integer.class,
                checkpointId);
        return trailIds;
    }

    //use all the checkpoint id to make a list, check if all the checkpoint id of a trail is included in the checkpoint list
    public boolean isCompleted(List<Integer> userCheckpoint, int trailId) {
        String sql = "SELECT checkpoint_id FROM trail_checkpoint WHERE trail_id = ?";
        List<Integer> checkpointIds = jdbcTemplate.queryForObject(sql,
                List.class,
                trailId);
        for (int checkpointId : checkpointIds) {
            if (!userCheckpoint.contains(checkpointId)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public TrailEntity getTrailById(int id) {
        String sql = "SELECT * FROM trail WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, trailRowMapper, id);
    }

    //get user collected trails by user id
    @Override
    public List<TrailEntity> getCollectedTrailsByUserId(int userId) {
        String sql = "SELECT t.* FROM trail t " +
                "INNER JOIN u.collection_user ut ON t.id = ut.trailid " +
                "WHERE ut.userid = ?";
        return jdbcTemplate.query(sql, trailRowMapper, userId);
    }

}



