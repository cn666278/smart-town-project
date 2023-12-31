package com.team2.smarttowns.controller.api;

import com.google.gson.Gson;
import com.team2.smarttowns.service.TrailService;
import com.team2.smarttowns.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Trails api
 * Get all trails data
 * Get all trails data by user id
 * Get all completed trails data by user id
 * @see TrailService
 *
 * @version 1.0
 * @author CHENKE SUN
 */
@RestController
public class TrailsApi {
        TrailService trailService;
        UserService userService;

        @GetMapping("/api/trails")
        public String getAllTrailsDataApi() {
                Gson gson = new Gson();
                return gson.toJson(trailService.getAllTrails());
        }

        @PostMapping("/api/trails/GetUserTrails")
        public String getUserTrailsDataApi(@RequestParam("userId") int userId) {
                Gson gson = new Gson();
                return gson.toJson(userService.getTrailsByUserId(userId));
        }
        @PostMapping("/api/trails/GetUserCompletedTrails")
        public String getUserCompletedTrailsDataApi(@RequestParam("userId") int userId) {
                Gson gson = new Gson();
                return gson.toJson(userService.getCompletedTrailsByUserId(userId));
        }

        @Autowired
        public TrailsApi(TrailService trailService, UserService userService) {
                this.trailService = trailService;
                this.userService = userService;
        }
}
