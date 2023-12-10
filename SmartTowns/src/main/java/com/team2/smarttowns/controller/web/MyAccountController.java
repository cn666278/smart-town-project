package com.team2.smarttowns.controller.web;

import com.team2.smarttowns.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MyAccountController {

    UserService userService;

    @RequestMapping("/myaccount")
    public ModelAndView myaccount() {
        return new ModelAndView("myaccount.html");
    }

    @GetMapping("/myaccount/user/{userId}")
    public ModelAndView myaccountUser(@PathVariable("userId") int userId) {
        ModelAndView modelAndView = new ModelAndView("myaccount.html");
        modelAndView.addObject("userId", userId);
        modelAndView.addObject("user", userService.getUserById(userId));
        return modelAndView;
    }

}
