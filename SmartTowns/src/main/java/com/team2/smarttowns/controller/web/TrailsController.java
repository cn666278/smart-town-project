package com.team2.smarttowns.controller.web;

import com.google.gson.Gson;
import com.team2.smarttowns.model.Checkpoint;
import com.team2.smarttowns.service.CheckpointService;
import com.team2.smarttowns.service.TrailService;
import com.team2.smarttowns.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class TrailsController {
    TrailService trailService;

    CheckpointService checkpointService;
    @RequestMapping("/trails")
    public ModelAndView trails() {
        ModelAndView modelAndView = new ModelAndView("trails.html");
        return modelAndView;
    }
    @RequestMapping("/trails/{trailId}")
    public ModelAndView trailDetails(@PathVariable("trailId") int trailId) {
        ModelAndView modelAndView = new ModelAndView("trails.html");
        modelAndView.addObject("trailId", trailId);
        Gson gson = new Gson();
        modelAndView.addObject("trails",trailService.getTrailById(trailId));
        modelAndView.addObject("checkpoints",checkpointService.getCheckpointsByTrailId(trailId));
        return modelAndView;
    }

    @Autowired
    public TrailsController(CheckpointService checkpointService, TrailService trailService) {
        this.trailService = trailService;
        this.checkpointService = checkpointService;
    }
}
