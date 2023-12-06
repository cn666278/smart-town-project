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
    public void getUserTrails(int id) {
        // get checkpoint user visited by user id

        TrailRepositoryImpl trailRepository = new TrailRepositoryImpl();
        List<CheckpointEntity> checkpointEntities = trailRepository.getCheckpointsById(id);


        // Find all the checkpoints corresponding to the trail,
        // and then put the trail into a non-repetitive list.
        for (CheckpointEntity checkpointEntity : checkpointEntities) {
            int checkpointId = checkpointEntity.getId();
            // get trail by trail id
//            Trail trail = trailRepository.getTrailIdByCheckPointId(checkpointId);
        }


    }

    public List<Integer> getCompletedTrailsByUserId(int id) {
        TrailRepositoryImpl trailRepository = new TrailRepositoryImpl();
        return trailRepository.getCompletedTrailsByUserId(id);
    }


}