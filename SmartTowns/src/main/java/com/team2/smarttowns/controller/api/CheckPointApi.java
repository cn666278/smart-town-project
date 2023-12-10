package com.team2.smarttowns.controller.api;

import com.google.gson.Gson;
import com.team2.smarttowns.model.Checkpoint;
import com.team2.smarttowns.service.CheckpointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CheckPointApi {


    //todo change to autowired

    CheckpointService checkpointService;

    /**
     * Get all checkpoints by trail id
     * @param trailId
     * @return json string
     */
    @PostMapping("/api/getcheckpointsbytrailid")
    public String getCheckpointsByTrailId(@RequestParam("trailId") int trailId) {
        List<Checkpoint> checkpoints = checkpointService.getCheckpointsByTrailId(trailId);
        Gson gson = new Gson();
        return gson.toJson(checkpoints);
    }

    public CheckPointApi(CheckpointService checkpointService) {
        this.checkpointService = checkpointService;
    }
}
