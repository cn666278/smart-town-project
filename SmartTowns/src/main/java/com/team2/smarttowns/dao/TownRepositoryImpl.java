package com.team2.smarttowns.dao;

import com.team2.smarttowns.entity.TownEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TownRepositoryImpl implements TownRepository{

    private JdbcTemplate jdbcTemplate;
    private RowMapper<TownEntity> townRowMapper;

    public TownRepositoryImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
        setTownMapper();
    }

    /**
     * Sets the townRowMapper to be used by the jdbcTemplate
     */
    private void setTownMapper(){
        townRowMapper = (resultSet, i) -> {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String detail = resultSet.getString("detail");
            String image = resultSet.getString("image");
            return new TownEntity(id, name, detail, image);
        };
    }

    @Override
    public TownEntity getTownById(int id){
        String sql = "SELECT * FROM towns WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, townRowMapper, id);
    }

    @Override
    public List<TownEntity> getAllTowns(){
        String sql = "SELECT * FROM towns";
        return jdbcTemplate.query(sql, townRowMapper);
    }
}
