package com.team2.smarttowns.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CheckpointController {
    @GetMapping("/checkout")
    public ModelAndView checkpointPage() {
        ModelAndView modelAndView = new ModelAndView("checkpoint.html");
        return modelAndView;
    }
}
