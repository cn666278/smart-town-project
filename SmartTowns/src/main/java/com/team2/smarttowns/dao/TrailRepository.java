package com.team2.smarttowns.dao;

import com.team2.smarttowns.entity.CheckpointEntity;
import com.team2.smarttowns.entity.TrailEntity;

import java.util.List;

public interface TrailRepository {


    List<TrailEntity> getAllTrails();
    public List<CheckpointEntity> getCheckpointsByTrailId(int id);

    List<CheckpointEntity> getCheckpointsByUserId(int userId);

    TrailEntity getTrailById(int id);

    List<TrailEntity> getTrailsByUserId(int id);

    List<TrailEntity> getTrailByUserId(int UserId);

    List<Integer> getCompletedTrailsByUserId(int id);

    //get user collected trails by user id
    List<TrailEntity> getCollectedTrailsByUserId(int userId);

//    void addTrail(TrailEntity trailEntity);
//    void updateTrail(TrailEntity trailEntity);
//    void deleteTrail(int id);
}
