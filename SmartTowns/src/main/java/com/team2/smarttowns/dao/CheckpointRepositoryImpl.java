package com.team2.smarttowns.dao;

import com.team2.smarttowns.entity.CheckpointEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CheckpointRepositoryImpl implements CheckpointRepository {
    private JdbcTemplate jdbc;
    private RowMapper<CheckpointEntity> checkpointMapper; // an interface for mapping rows of a database result set to Java objects


    public CheckpointRepositoryImpl(JdbcTemplate aJdbc) {
        this.jdbc = aJdbc;
        setCheckpointMapper();
    }

    private void setCheckpointMapper() {
        checkpointMapper = (rs, i) -> new CheckpointEntity(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("img"),
                rs.getString("description"),
                rs.getString("contact"),
                rs.getString("latitude"),
                rs.getString("longitude"),
                rs.getString("address")
        );
    }

    @Override
    public List<CheckpointEntity> getAll() {
        String sql = "select * from checkpoint";
        return jdbc.query(sql, checkpointMapper);
    }

    @Override
    public CheckpointEntity getById(int id) {
        String sql = "SELECT * FROM checkpoints WHERE id = ?";
        return jdbc.queryForObject(sql, checkpointMapper, id);
    }

    @Override
    public void addOne(CheckpointEntity checkpointEntity) {
        String sql = "INSERT INTO checkpoints (id,,lantitude,longitude,name,image,detail) VALUES (?,?,?,?,?,?)";
        jdbc.update(sql, checkpointEntity.getId(), checkpointEntity.getName(), checkpointEntity.getImg(), checkpointEntity.getDescription(),
                checkpointEntity.getContact(), checkpointEntity.getLatitude(), checkpointEntity.getLongitude(), checkpointEntity.getAddress());
    }


    @Override
    public void updateOne(CheckpointEntity checkpointEntity) {
        String sql = "UPDATE checkpoints SET lantitude = ?, longitude = ?, name = ?, image = ?, detail = ? WHERE id = ?";
        jdbc.update(sql, checkpointEntity.getName(), checkpointEntity.getImg(), checkpointEntity.getDescription(),
                checkpointEntity.getContact(), checkpointEntity.getLatitude(), checkpointEntity.getLongitude(), checkpointEntity.getAddress());
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM checkpoints WHERE id = ?";
        jdbc.update(sql, id);
    }
}
