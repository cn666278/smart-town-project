package com.team2.smarttowns.config;

import com.team2.smarttowns.entity.CheckpointEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.RowMapper;

@Configuration
public class RowMapperConfig {

    @Bean
    public RowMapper<CheckpointEntity> checkpointRowMapper() {
        return (rs, rowNum) -> {
            CheckpointEntity entity = new CheckpointEntity();
            // fill in the entity fields from the ResultSet
            return entity;
        };
    }
}