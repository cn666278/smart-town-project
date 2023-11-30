package com.team2.smarttowns.users;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class UserRepositoryJDBC implements UserRepository{

        private JdbcTemplate jdbcTemplate;

        private RowMapper<User> userRowMapper;

    public UserRepositoryJDBC(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private void setUserMapper() {
        userRowMapper = (resultSet, i) -> {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String password = resultSet.getString("password");
            String profile_img = resultSet.getString("profile_img");
            String account = resultSet.getString("account");
            String email = resultSet.getString("email");
            String badget = resultSet.getString("badget");
            return new User(id, name, password, profile_img, account, email, badget);
        };
    }

    @Override
    public List<User> getAllUsers() {
        String sql= "SELECT * FROM users";
        return jdbcTemplate.query(sql, userRowMapper);
    }

    @Override
    public User getUserByAccount(String account) {
        return null;
    }

}
