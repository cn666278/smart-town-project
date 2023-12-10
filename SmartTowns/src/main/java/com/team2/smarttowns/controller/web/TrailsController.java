package com.team2.smarttowns.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class TrailsController {
    TrailService trailService;
    CheckpointService checkpointService;
    @RequestMapping("/trails")
    public ModelAndView trails() {
        ModelAndView modelAndView = new ModelAndView("trails.html");
        return modelAndView;
    }

    @Autowired
    public TrailsController(CheckpointService checkpointService, TrailService trailService) {
        this.trailService = trailService;
        this.checkpointService = checkpointService;
    }
}
