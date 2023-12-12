package com.team2.smarttowns.dao;

import com.team2.smarttowns.entity.CheckpointEntity;
import com.team2.smarttowns.entity.UserEntity;
import org.apache.tomcat.util.digester.RuleSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private JdbcTemplate jdbcTemplate;

    private RowMapper<UserEntity> userRowMapper=(rs, i) -> new UserEntity(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getString("password"),
            rs.getString("profile_img"),
            rs.getString("account"),
            rs.getString("email"),
            rs.getString("badge")
    );

    private RowMapper<CheckpointEntity> checkpointEntityRowMapper=(rs, i) -> new CheckpointEntity(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getString("image"),
            rs.getString("description"),
            rs.getString("contact"),
            rs.getString("latitude"),
            rs.getString("longitude"),
            rs.getString("address"),
            rs.getString("details")
    );

    CheckpointRepository checkpointRepository;

    @Override
    public List<UserEntity> getAllUsers() {
        String sql = "SELECT * FROM users";
        return jdbcTemplate.query(sql, userRowMapper);
    }

    @Override
    public UserEntity getUserByAccount(String account) {
        String sql = "SELECT * FROM users WHERE account = ?";
        return jdbcTemplate.queryForObject(sql, userRowMapper, account);
    }

    @Override
    public UserEntity getUserById(int id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, userRowMapper, id);
    }

    public List<CheckpointEntity> getCheckpointsByUserId(int id) {
        //get from user_checkpoint
        String sql = "SELECT * FROM checkpoint WHERE id IN (SELECT checkpoint_id FROM user_checkpoint WHERE user_id = ?)";
        return jdbcTemplate.query(sql,checkpointEntityRowMapper, id);
    }

    @Autowired
    public UserRepositoryImpl(JdbcTemplate jdbcTemplate, CheckpointRepository checkpointRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.checkpointRepository=checkpointRepository;
    }
}
