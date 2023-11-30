package com.team2.smarttowns.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MyAccountController {
    @RequestMapping("/myaccount")
    public ModelAndView myaccount() {
        return new ModelAndView("myaccount.html");
    }
}
