package com.team2.smarttowns.controller.web;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class TrailsMapController {

    TrailService trailService;

    CheckpointService checkpointService;

    @RequestMapping("/trailsmap")
    public ModelAndView trailsmap() {
        ModelAndView modelAndView = new ModelAndView("trailsmap.html");
        return modelAndView;
    }

    @RequestMapping("/trailsmap/{trailId}")
    public ModelAndView trailDetails(@PathVariable("trailId") int trailId) {
        ModelAndView modelAndView = new ModelAndView("trailsmap.html");
        modelAndView.addObject("trailId", trailId);
        modelAndView.addObject("trails",trailService.getTrailById(trailId));
        modelAndView.addObject("checkpoints",checkpointService.getCheckpointsByTrailId(trailId));
        return modelAndView;
    }

    @Autowired
    public TrailsMapController(CheckpointService checkpointService, TrailService trailService) {
        this.trailService = trailService;
        this.checkpointService = checkpointService;
    }
}
