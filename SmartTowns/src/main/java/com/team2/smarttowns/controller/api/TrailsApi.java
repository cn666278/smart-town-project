package com.team2.smarttowns.controller.api;

import com.google.gson.Gson;
import com.team2.smarttowns.model.Checkpoint;
import com.team2.smarttowns.service.RankService;
import com.team2.smarttowns.service.TrailService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TrailsApi {
        TrailService trailService=new TrailService();
        @GetMapping("/api/trails")
        public String getAllTrailsDataApi() {
                Gson gson = new Gson();
                return gson.toJson(trailService.getAllTrails());
        }
}
