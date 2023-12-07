package com.team2.smarttowns.service;

import com.team2.smarttowns.dao.TrailRepositoryImpl;
import com.team2.smarttowns.entity.CheckpointEntity;
import com.team2.smarttowns.model.Checkpoint;
import com.team2.smarttowns.model.Trail;
import com.team2.smarttowns.entity.TrailEntity;
import java.util.ArrayList;
import java.util.List;

public class TrailService {
    public List<Trail> getAllTrails() {
        TrailRepositoryImpl trailRepository = new TrailRepositoryImpl();
        List<Trail> trails = new ArrayList<>();
        //get data from dao. Then transfer entity to model

        List<TrailEntity> trailEntities = trailRepository.getAllTrails();

        for (TrailEntity trailEntity : trailEntities) {
            Trail trail = new Trail();
            trail.setId(trailEntity.getId());
            trail.setName(trailEntity.getName());
            trail.setImage(trailEntity.getImage());
            trail.setDetails(trailEntity.getDetails());
            for (CheckpointEntity checkpointEntity : trailRepository.getCheckpointsByTrailId(trailEntity.getId())) {
                Checkpoint checkpoint = checkpointEntityToModel(checkpointEntity);
                trail.getCheckpoints().add(checkpoint);
            }
            trails.add(trail);
        }

        return trails;

    }

    public Checkpoint checkpointEntityToModel(CheckpointEntity checkpointEntity) {
        Checkpoint checkpoint = new Checkpoint();
        checkpoint.setId(checkpointEntity.getId());
        checkpoint.setLatitude(checkpointEntity.getLatitude());
        checkpoint.setLongitude(checkpointEntity.getLongitude());
        return checkpoint;
    }


}
