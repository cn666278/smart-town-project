package com.team2.smarttowns.service;

import com.team2.smarttowns.dao.CheckpointRepository;
import com.team2.smarttowns.dao.CheckpointRepositoryImpl;
import com.team2.smarttowns.entity.CheckpointEntity;
import com.team2.smarttowns.model.Checkpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Get user info and checkpoints user have accessed.
 */
@Service
public class RankService {
    private final CheckpointRepository checkpointRepository;

    @Autowired
    public RankService(CheckpointRepository checkpointRepository) {
        this.checkpointRepository = checkpointRepository;
    }

    public List<Checkpoint> getAllUserCheckpoints() {
        List<Checkpoint> checkpoints = new ArrayList<>();

        // 需要所有用户访问过的检查点
        List<CheckpointEntity> checkpointEntities = checkpointRepository.getAllCheckpoints();

        for (CheckpointEntity checkpointEntity : checkpointEntities) {
            checkpoints.add(checkpointEntityToModel(checkpointEntity));
        }

        return checkpoints;
    }

    public List<Checkpoint> checkpointUserAccessed(int userID) {
        List<Checkpoint> checkpoints = new ArrayList<>();

        // 需要用户访问过的检查点
        List<CheckpointEntity> checkpointEntities = checkpointRepository.getUserAccessedCheckpointsByUserId(userID);

        for (CheckpointEntity checkpointEntity : checkpointEntities) {
            checkpoints.add(checkpointEntityToModel(checkpointEntity));
        }

        return checkpoints;
    }




    public Checkpoint checkpointEntityToModel(CheckpointEntity checkpointEntity)
    {
        Checkpoint checkpoint=new Checkpoint();
        checkpoint.setId(checkpointEntity.getId());
        checkpoint.setName(checkpointEntity.getName());
        checkpoint.setImage(checkpointEntity.getImage());
        checkpoint.setLatitude(checkpointEntity.getLatitude());
        checkpoint.setLongitude(checkpointEntity.getLongitude());
        checkpoint.setAddress(checkpointEntity.getAddress());
        checkpoint.setDetail(checkpointEntity.getDetail());
        return (checkpoint);
    }
}
