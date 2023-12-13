package com.team2.smarttowns.controller.web;

import com.team2.smarttowns.service.TrailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    TrailService trailService;

    @GetMapping("/home")
    public ModelAndView homePage() {
        ModelAndView modelAndView = new ModelAndView("home.html");
         modelAndView.addObject("trails", trailService.getAllTrails());
        return modelAndView;
    }

    @Autowired
    public HomeController(TrailService trailService) {
        this.trailService = trailService;
    }

}
