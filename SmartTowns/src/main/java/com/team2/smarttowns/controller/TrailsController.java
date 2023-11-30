package com.team2.smarttowns.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class TrailsController {
    @RequestMapping("/trails")
    public ModelAndView trails() {
        ModelAndView modelAndView = new ModelAndView("trails.html");
        return modelAndView;
    }

}
