package com.team2.smarttowns.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TownsController {

    @GetMapping("/towns")
    public ModelAndView homePage() {
        ModelAndView modelAndView = new ModelAndView("town.html");
        return modelAndView;
    }

}
