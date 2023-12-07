package com.team2.smarttowns.controller.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class AboutUsController {
    @RequestMapping("/about")
    public ModelAndView trails() {
        ModelAndView modelAndView = new ModelAndView("about.html");
        return modelAndView;
    }

}
