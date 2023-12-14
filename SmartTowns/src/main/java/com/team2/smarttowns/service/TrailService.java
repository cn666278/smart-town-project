package com.team2.smarttowns.service;

import com.team2.smarttowns.dao.TrailRepository;
import com.team2.smarttowns.dao.TrailRepositoryImpl;
import com.team2.smarttowns.entity.CheckpointEntity;
import com.team2.smarttowns.model.Checkpoint;
import com.team2.smarttowns.model.Trail;
import com.team2.smarttowns.entity.TrailEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName TrailService
 * @Description Trail Service. Use to get data from dao and transfer entity to model
 * @Author CHENKE SUN
 *
 * @version 1.0
 *
 **/
@Service
public class TrailService {
    private final TrailRepository trailRepository;

    /**
     * Get all trails
     * @return List<Trail>
     *     List of trails
     *
     * @version 1.0
     * @auther CHENKE SUN
     * @see Trail
     * @see TrailEntity
     *
     */
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

    /**
     * Transfer trail entity to trail model
     * @param trailEntity
     * @param trail
     *
     * @version 1.0
     * @auther CHENKE SUN
     */
    private void trailEntityToModel(TrailEntity trailEntity, Trail trail) {
        trail.setId(trailEntity.getId());
        trail.setName(trailEntity.getName());
        trail.setImage(trailEntity.getImage());
        trail.setDetails(trailEntity.getDetails());
        for (CheckpointEntity checkpointEntity : trailRepository.getCheckpointsByTrailId(trailEntity.getId())) {
            Checkpoint checkpoint = checkpointEntityToModel(checkpointEntity);
            trail.getCheckpoints().add(checkpoint);
        }
    }

    /**
     * Get trail by its trailid, including all checkpoints
     * @param id
     * @return trail
     *
     * @version 1.0
     * @auther CHENKE SUN
     */
    public Trail getTrailById(int id) {
        Trail trail = new Trail();
        TrailEntity trailEntity = trailRepository.getTrailById(id);
        trailEntityToModel(trailEntity, trail);
        return trail;
    }

    public List<Trail> getTrailsByUserId(int id) {
        List<Trail> trails =new ArrayList<>();
        List<TrailEntity> trailEntities = trailRepository.getTrailsByUserId(id);
        for (TrailEntity trailEntity : trailEntities) {
                Trail trail = new Trail();
                trailEntityToModel(trailEntity, trail);
            trails.add(trail);
        }
        return trails;
    }

    public TrailEntity trailModelToEntity(Trail trail) {
        TrailEntity trailEntity=new TrailEntity();
        trailEntity.setId(trail.getId());
        trailEntity.setName(trail.getName());
        trailEntity.setImage(trail.getImage());
        trailEntity.setDetails(trail.getDetails());
        return trailEntity;
    }

    public Checkpoint checkpointEntityToModel(CheckpointEntity checkpointEntity) {
        Checkpoint checkpoint = new Checkpoint();
        checkpoint.setId(checkpointEntity.getId());
        checkpoint.setLatitude(checkpointEntity.getLatitude());
        checkpoint.setLongitude(checkpointEntity.getLongitude());
        return checkpoint;
    }

    public Trail transferTrailEntityToModel(TrailEntity trailEntity) {
        Trail trail = new Trail();
        trail.setId(trailEntity.getId());
        trail.setName(trailEntity.getName());
        trail.setImage(trailEntity.getImage());
        trail.setDetails(trailEntity.getDetails());
        return trail;
    }

    public List<Trail> getTrailsByUserId(List<Integer> trailIds) {
        List<Trail> trails = new ArrayList<>();
        //get data from dao. Then transfer entity to model
        for (Integer trailId : trailIds) {
            Trail trail = getTrailById(trailId);
            trails.add(trail);
        }
        return trails;
    }

    @Autowired
    public TrailService(TrailRepository trailRepository) {
        this.trailRepository = trailRepository;
    }

}
