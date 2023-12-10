package com.team2.smarttowns.service;

import com.team2.smarttowns.dao.CheckpointRepository;
import com.team2.smarttowns.dao.CheckpointRepositoryImpl;
import com.team2.smarttowns.entity.CheckpointEntity;
import com.team2.smarttowns.model.Checkpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class CheckpointService {


    @Autowired
    private CheckpointRepository checkpointRepository;
    public List<Checkpoint> getCheckpointsByTrailId(int trailId) {
        List<Checkpoint> checkpoints = new ArrayList<>();
        //get data from dao. Then transfer entity to model
        //todo change to autowired
        //CheckpointRepositoryImpl checkpointRepository = new CheckpointRepositoryImpl();
        List<CheckpointEntity> checkpointEntities = checkpointRepository.getCheckpointsByTrailId(trailId);
        for (CheckpointEntity checkpointEntity : checkpointEntities) {
            Checkpoint checkpoint = transferCheckpointEntityToModel(checkpointEntity);
            checkpoints.add(checkpoint);
        }
        return checkpoints;
    }

    public Checkpoint transferCheckpointEntityToModel(CheckpointEntity checkpointEntity) {
        Checkpoint checkpoint = new Checkpoint();
        checkpoint.setId(checkpointEntity.getId());
        checkpoint.setLatitude(checkpointEntity.getLatitude());
        checkpoint.setLongitude(checkpointEntity.getLongitude());
        checkpoint.setName(checkpointEntity.getName());
        checkpoint.setImage(checkpointEntity.getImage());
        checkpoint.setDescription(checkpointEntity.getDescription());
        return checkpoint;
    }

}
