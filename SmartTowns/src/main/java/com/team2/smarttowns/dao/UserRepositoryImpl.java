package com.team2.smarttowns.dao;

import com.team2.smarttowns.entity.UserEntity;
import com.team2.smarttowns.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private JdbcTemplate jdbcTemplate;

    private RowMapper<UserEntity> userRowMapper;

    public UserRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        setUserMapper();
    }

    private void setUserMapper() {
        userRowMapper = (resultSet, i) -> {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String password = resultSet.getString("password");
            String profileImg = resultSet.getString("profile_img");
            String account = resultSet.getString("account");
            String email = resultSet.getString("email");
            String badge = resultSet.getString("badge");
            return new UserEntity(id, name, password, profileImg, account, email, badge);
        };
    }

    @Override
    public List<UserEntity> getAllUsers() {
        String sql = "SELECT * FROM users";
        return jdbcTemplate.query(sql, userRowMapper);
    }

    @Override
    public User getUserByAccount(String account) {
        return null;
    }

}
