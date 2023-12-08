package com.team2.smarttowns.controller.api;

import com.team2.smarttowns.model.Checkpoint;
import com.team2.smarttowns.service.RankService;
import com.team2.smarttowns.service.TrailService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.google.gson.Gson;
import java.awt.desktop.SystemEventListener;
import java.util.List;

@RestController
public class RankApi {
    TrailService trailService = new TrailService();
    RankService rankService = new RankService();

//    @PostMapping("/api/checkpointUserAccessed")
//    public String checkpointUserAccessed(@RequestParam("userId") int userId) {
//        Gson gson = new Gson();
//        System.out.println(gson.toJson(rankService.checkpointUserAccessed(userId)));
//        return gson.toJson(rankService.checkpointUserAccessed(userId));
//    }
}
