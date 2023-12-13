package com.team2.smarttowns.controller.web;

import com.google.gson.Gson;
import com.team2.smarttowns.dao.CheckpointRepository;
import com.team2.smarttowns.model.Checkpoint;
import com.team2.smarttowns.model.UserAccessedCheckpointRank;
import com.team2.smarttowns.service.RankService;
import com.team2.smarttowns.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@RestController
public class RankWebController {

    private final RankService rankService;

    @Autowired
    public RankWebController(RankService rankService) {
        this.rankService = rankService;
    }

    @GetMapping("/rank-trail")
    public ModelAndView rankTrailWeb(Principal principal) {
        // Create a ModelAndView object, specifying the "rank-trail.html" template
        ModelAndView modelAndView = new ModelAndView("rank-trail.html");

        // If the user is already logged in
        if (principal != null) {
            // Retrieve the username from the Principal object
            String name = principal.getName();
            UserAccessedCheckpointRank userInfoByName = rankService.getUserInfoByName(name);
            modelAndView.addObject("currentUser", userInfoByName);
        }

        // Get the sorted list of checkpoints based on user access
        List<UserAccessedCheckpointRank> checkpoints = rankService.getRankListSorted();
        System.out.println(checkpoints);

        // Add the list of checkpoints to the model for use in the view
        modelAndView.addObject("checkpoints", checkpoints);

        // Return the ModelAndView object containing the model and view
        return modelAndView;
    }



    @GetMapping("/rank-town")
    ModelAndView rankTownWeb() {
        ModelAndView modelAndView = new ModelAndView("rank-town.html");
        //List<Checkpoint> checkpoints = rankService.getAllUserCheckpoints();

        List<UserAccessedCheckpointRank> trails = rankService.getRankListSorted();
        System.out.println(trails);
        modelAndView.addObject("trails", trails);
        return modelAndView;
    }

}
