package com.team2.smarttowns.dao;

import com.team2.smarttowns.entity.CheckpointEntity;
import com.team2.smarttowns.entity.UserEntity;
import com.team2.smarttowns.model.UserAccessedCheckpointRank;
import org.apache.tomcat.util.digester.RuleSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private JdbcTemplate jdbcTemplate;

    private RowMapper<UserEntity> userRowMapper = (rs, i) -> new UserEntity(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getString("password"),
            rs.getBoolean("enabled"),
            rs.getString("profile_img"),
            rs.getString("account"),
            rs.getString("email"),
            rs.getString("badge")
    );

    private RowMapper<CheckpointEntity> checkpointEntityRowMapper = (rs, i) -> new CheckpointEntity(
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
        String sql = "SELECT * FROM user";
        return jdbcTemplate.query(sql, userRowMapper);
    }

    @Override
    public UserEntity getUserByAccount(String account) {
        String sql = "SELECT * FROM user WHERE account = ?";
        return jdbcTemplate.queryForObject(sql, userRowMapper, account);
    }

    @Override
    public UserEntity getUserById(int id) {
        String sql = "SELECT * FROM user WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, userRowMapper, id);
    }

    /**
     * for registration
     * @param user
     * @return userId for add new users_roles record
     */
    @Override
    public int addUser(UserEntity user) {
        // SQL query to insert user information into the 'user' table
        String sql = "INSERT INTO user (name,email,password) VALUES (?,?,?)";

        // Execute the SQL update using Spring JDBC's JdbcTemplate
        jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getPassword());

        // SQL query to retrieve the maximum 'id' from the 'user' table
        String sql2 = "SELECT MAX(id) FROM user";

        // Retrieve and return the maximum 'id' using Spring JDBC
        int maxId = jdbcTemplate.queryForObject(sql2, Integer.class);
        return maxId;
    }

    /**
     * to assign user to certain role(admin,user,...)
     * @param userId
     * @param roleId
     */
    @Override
    public void assignRole4User(int userId, int roleId) {
        // SQL query to insert user and role association into the 'users_roles' table
        String sql = "INSERT INTO users_roles (user_id,role_id) VALUES (?,?)";

        // Execute the SQL update using Spring JDBC's JdbcTemplate
        jdbcTemplate.update(sql, userId, roleId);
    }

    @Override
    public UserAccessedCheckpointRank getUserInfoByName(String name) {
        String userInfoSql = "SELECT id, name, (SELECT COUNT(*) FROM user_checkpoint WHERE user_id = u.id) AS checkpointAmount FROM user u WHERE name = ?";

        return jdbcTemplate.queryForObject(userInfoSql, new Object[]{name}, (rs, rowNum) -> {
            UserAccessedCheckpointRank userInfo = new UserAccessedCheckpointRank();
            userInfo.setId(rs.getInt("id"));
            userInfo.setName(rs.getString("name"));
            userInfo.setCount(rs.getInt("checkpointAmount"));
            return userInfo;
        });
    }

    public List<CheckpointEntity> getCheckpointsByUserId(int id) {
        //get from user_checkpoint
        String sql = "SELECT * FROM checkpoint WHERE id IN (SELECT checkpoint_id FROM user_checkpoint WHERE user_id = ?)";
        return jdbcTemplate.query(sql, checkpointEntityRowMapper, id);
    }

    /**
     * update user info use this userEntity.id's user
     * @param userEntity user
     */
    @Override
    public void updateUser(UserEntity userEntity) {
        String sql = "UPDATE users SET name = ?, password = ?, profile_img = ?, account = ?, email = ?, badge = ? WHERE id = ?";
        jdbcTemplate.update(sql, userEntity.getName(), userEntity.getPassword(), userEntity.getProfileImg(), userEntity.getAccount(), userEntity.getEmail(), userEntity.getBadge(), userEntity.getId());
    }

    @Autowired
    public UserRepositoryImpl(JdbcTemplate jdbcTemplate, CheckpointRepository checkpointRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.checkpointRepository = checkpointRepository;
    }


}
