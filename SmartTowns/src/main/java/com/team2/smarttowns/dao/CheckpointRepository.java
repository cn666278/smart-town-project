package com.team2.smarttowns.dao;

import com.team2.smarttowns.entity.CheckpointEntity;

import java.util.List;

public interface CheckpointRepository {
    List<CheckpointEntity> getAll();
    CheckpointEntity getById(int id);
    void addOne(CheckpointEntity checkpointEntity);
    void updateOne(CheckpointEntity checkpointEntity);
    void deleteById(int id);

}
