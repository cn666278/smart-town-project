package com.team2.smarttowns.service;

import com.team2.smarttowns.dao.TrailRepositoryImpl;
import com.team2.smarttowns.entity.CheckpointEntity;
import com.team2.smarttowns.model.Checkpoint;
import com.team2.smarttowns.model.Trail;
import com.team2.smarttowns.entity.TrailEntity;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrailService {
    private final TrailRepository trailRepository;
    public List<Trail> getAllTrails() {
        List<Trail> trails = new ArrayList<>();
        //get data from dao. Then transfer entity to model
        List<TrailEntity> trailEntities = trailRepository.getAllTrails();

        for (TrailEntity trailEntity : trailEntities) {
            Trail trail = new Trail();
            trailEntityToModel(trailEntity, trail);
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

    @Autowired
    public TrailService(TrailRepository trailRepository) {
        this.trailRepository = trailRepository;
    }

}
