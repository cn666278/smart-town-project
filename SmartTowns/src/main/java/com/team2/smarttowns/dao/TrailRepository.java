package com.team2.smarttowns.dao;

import com.team2.smarttowns.entity.CheckpointEntity;
import com.team2.smarttowns.entity.TrailEntity;

import java.util.List;

public interface TrailRepository {


    List<TrailEntity> getAllTrails();
    public List<CheckpointEntity> getCheckpointsByTrailId(int id);

    List<CheckpointEntity> getCheckpointsByUserId(int userId);

    TrailEntity getTrailById(int id);

    List<Integer> getTrailsByUserId(int id);

    List<Integer> getCompletedTrailsByUserId(int id);

    //get user collected trails by user id
    List<TrailEntity> getCollectedTrailsByUserId(int userid);

//    void addTrail(TrailEntity trailEntity);
//    void updateTrail(TrailEntity trailEntity);
//    void deleteTrail(int id);
}
