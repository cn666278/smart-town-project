package com.team2.smarttowns.dao;

import com.team2.smarttowns.entity.CheckpointEntity;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@NoArgsConstructor
@Repository
public class CheckpointRepositoryImpl implements CheckpointRepository {


    private JdbcTemplate jdbc;
    private RowMapper<CheckpointEntity> checkpointMapper = (rs, i) -> new CheckpointEntity(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getString("image"),
            rs.getString("description"),
            rs.getString("contact"),
            rs.getString("latitude"),
            rs.getString("longitude"),
            rs.getString("address"),
            rs.getString("details")
    );; // an interface for mapping rows of a database results set to Java objects

    @Autowired
    public CheckpointRepositoryImpl(JdbcTemplate aJdbc) {
        this.jdbc = aJdbc;
    }


    @Override
    public List<CheckpointEntity> getAllCheckpoints() {
        String sql = "select * from checkpoint";
        return jdbc.query(sql, checkpointMapper);
    }

    @Override
    public CheckpointEntity getCheckpointById(int id) {
        String sql = "SELECT * FROM checkpoint WHERE id = ?";
        return jdbc.queryForObject(sql, checkpointMapper, id);
    }

    @Override
    public void addCheckpoint(CheckpointEntity checkpointEntity) {
        String sql = "INSERT INTO checkpoint (name,image,description,contact,latitude,longitude,address) VALUES (?,?,?,?,?,?,?)";
        jdbc.update(sql, checkpointEntity.getName(), checkpointEntity.getImage(), checkpointEntity.getDescription(),
                checkpointEntity.getContact(), checkpointEntity.getLatitude(), checkpointEntity.getLongitude(), checkpointEntity.getAddress());
    }


    @Override
    public void updateCheckpoint(CheckpointEntity checkpointEntity) {
        String sql = "UPDATE checkpoint SET name = ?, image = ?, description = ?, contact = ?, latitude = ?,longitude=?,address=? WHERE id = ?";
        jdbc.update(sql, checkpointEntity.getName(), checkpointEntity.getImage(), checkpointEntity.getDescription(), checkpointEntity.getContact(),
                checkpointEntity.getLatitude(), checkpointEntity.getLongitude(), checkpointEntity.getAddress(), checkpointEntity.getId());
    }

    @Override
    public void deleteCheckpoint(int id) {
        String sql = "DELETE FROM checkpoint WHERE id = ?";
        jdbc.update(sql, id);
    }

    @Override
    public void addUserCheckpoint(int checkpointId, int userId) {
        String sql = "INSERT INTO user_checkpoint (checkpoint_id,user_id) VALUES (?,?)";
        jdbc.update(sql, checkpointId, userId);
    }

    @Override
    public List<CheckpointEntity> getCheckpointsByTrailId(int trailId) {
        String sql = "SELECT c.*\n" +
                "FROM checkpoint c\n" +
                "JOIN trail_checkpoint tc ON c.id = tc.checkpoint_id\n" +
                "WHERE tc.trail_id = ?";
        return jdbc.query(sql, checkpointMapper, trailId);
    }

    @Override
    public List<Integer> getByUserId(int userId) {
        String sql = "SELECT checkpoint_id FROM user_checkpoint WHERE user_id = ?";
        return jdbc.queryForList(sql, Integer.class, userId);
    }

    @Override
    public List<CheckpointEntity> getUserAccessedCheckpointsByUserId(int userId) {
        String sql = "SELECT c.*\n" +
                "FROM checkpoint c\n" +
                "JOIN user_checkpoint uc ON c.id = uc.checkpoint_id\n" +
                "WHERE uc.user_id = ?;";
        return jdbc.query(sql, checkpointMapper);
    }

    @Override
    public List<CheckpointEntity> getCheckpointsByUserId(int trailId) {
        String sql = "SELECT c.*\n" +
                "FROM checkpoint c\n" +
                "JOIN trail_checkpoint tc ON c.id = tc.checkpoint_id\n" +
                "WHERE tc.trail_id = ?";
        return jdbc.query(sql, checkpointMapper, trailId);
    }
}
