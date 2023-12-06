package com.team2.smarttowns.dao;

import com.team2.smarttowns.entity.CheckpointEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

@org.springframework.stereotype.Repository
public class CheckpointRepositoryImpl implements CheckpointRepository{
    private JdbcTemplate jdbcTemplate;

    private RowMapper<CheckpointEntity> checkpointRowMapper;

    public CheckpointRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<CheckpointEntity> getAllCheckpoints() {
        String sql = "SELECT * FROM checkpoints";
        return jdbcTemplate.query(sql, checkpointRowMapper);
    }

    @Override
    public CheckpointEntity getCheckpointById(int id) {
        String sql = "SELECT * FROM checkpoints WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, checkpointRowMapper, id);
    }

    @Override
    public void addCheckpoint(CheckpointEntity checkpointEntity) {
        String sql = "INSERT INTO checkpoints (id,,lantitude,longitude,name,image,detail) VALUES (?,?,?,?,?,?)";
        jdbcTemplate.update(sql, checkpointEntity.getId(), checkpointEntity.getLatitude(), checkpointEntity.getLongitude(), checkpointEntity.getName(), checkpointEntity.getImage(), checkpointEntity.getDetail());
    }


    @Override
    public void updateCheckpoint(CheckpointEntity checkpointEntity) {
        String sql = "UPDATE checkpoints SET lantitude = ?, longitude = ?, name = ?, image = ?, detail = ? WHERE id = ?";
        jdbcTemplate.update(sql, checkpointEntity.getLatitude(), checkpointEntity.getLongitude(), checkpointEntity.getName(), checkpointEntity.getImage(), checkpointEntity.getDetail(), checkpointEntity.getId());
    }

    @Override
    public void deleteCheckpoint(int id) {
        String sql = "DELETE FROM checkpoints WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

}
