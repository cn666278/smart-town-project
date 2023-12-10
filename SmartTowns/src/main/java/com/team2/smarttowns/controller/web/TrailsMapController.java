package com.team2.smarttowns.controller.web;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class TrailsMapController {
    @RequestMapping("/trailsmap")
    public ModelAndView trailsmap() {
        ModelAndView modelAndView = new ModelAndView("trailsmap.html");
        return modelAndView;
    }
}