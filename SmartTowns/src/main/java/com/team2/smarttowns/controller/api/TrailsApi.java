package com.team2.smarttowns.controller.api;

import com.google.gson.Gson;
import com.team2.smarttowns.model.User;
import com.team2.smarttowns.service.TrailService;
import com.team2.smarttowns.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrailsApi {
        TrailService trailService=new TrailService();
        @GetMapping("/api/trails")
        public String getAllTrailsDataApi() {
                Gson gson = new Gson();
                return gson.toJson(trailService.getAllTrails());
        }
        UserService userService=new UserService();
        @PostMapping("/api/trails/GetCompletedTrails")
        public String getCompletedTrailsDataApi(@RequestParam("userId") int userId) {
                Gson gson = new Gson();
                return gson.toJson(userService.getCompletedTrailsByUserId(userId));
        }
}
