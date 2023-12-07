package com.team2.smarttowns.service;

import com.team2.smarttowns.dao.TrailRepository;
import com.team2.smarttowns.dao.TrailRepositoryImpl;
import com.team2.smarttowns.entity.CheckpointEntity;

import java.util.List;

public class UserService {
    public UserService() {
    }

    /**
     * get user trails by the checkpoints user visited
     *
     * @param id user id
     */
    public List<Integer> getTrailsByUserId(int id) {
        TrailRepositoryImpl trailRepository = new TrailRepositoryImpl();
        return trailRepository.getTrailsByUserId(id);
    }

    public List<Integer> getCompletedTrailsByUserId(int id) {
        TrailRepositoryImpl trailRepository = new TrailRepositoryImpl();
        return trailRepository.getCompletedTrailsByUserId(id);
    }


}