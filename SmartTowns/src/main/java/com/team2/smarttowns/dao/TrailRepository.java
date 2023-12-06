package com.team2.smarttowns.dao;

import com.team2.smarttowns.entity.CheckpointEntity;
import com.team2.smarttowns.entity.TrailEntity;

import java.util.List;

public interface TrailRepository {


    List<TrailEntity> getAllTrails();
    public List<CheckpointEntity> getCheckpointsById(int id);

//    void addTrail(TrailEntity trailEntity);
//    void updateTrail(TrailEntity trailEntity);
//    void deleteTrail(int id);
}
