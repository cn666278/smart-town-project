package com.team2.smarttowns.dao;

import com.team2.smarttowns.entity.CheckpointEntity;

import java.util.List;

public interface CheckpointRepository {
    List<CheckpointEntity> getAllCheckpoints();
    CheckpointEntity getCheckpointById(int id);
    void addCheckpoint(CheckpointEntity checkpointEntity);
    void updateCheckpoint(CheckpointEntity checkpointEntity);
    void deleteCheckpoint(int id);

}
