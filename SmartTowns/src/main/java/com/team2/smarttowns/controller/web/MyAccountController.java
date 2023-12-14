package com.team2.smarttowns.controller.web;

import com.google.gson.Gson;
import com.team2.smarttowns.dao.CheckpointRepository;
import com.team2.smarttowns.dao.TrailRepository;
import com.team2.smarttowns.entity.TrailEntity;
import com.team2.smarttowns.model.Trail;
import com.team2.smarttowns.model.User;
import com.team2.smarttowns.service.TrailService;
import com.team2.smarttowns.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MyAccountController {

    UserService userService;


    CheckpointRepository checkpointRepository;
    TrailRepository trailRepository;

    TrailService trailService;

    @RequestMapping("/myaccount")
    public ModelAndView myaccount() {
        ModelAndView modelAndView = new ModelAndView("myaccount.html");
        modelAndView.addObject("userId",1);
        User user = userService.getUserById(1);
        modelAndView.addObject("user", userService.getUserById(1));
        modelAndView.addObject("myTrails", trailService.getAllTrails());
        modelAndView.addObject("completedTrails", trailService.getAllTrails());

        // get user trails by the checkpoints user visited
//        List<TrailEntity> userTrails1 = trailRepository.getTrailsByUserId(1);
//        List<Trail> userTrails = new ArrayList<>();
//        for (TrailEntity trailEntity : userTrails1) {
//            Trail trail = trailService.transferTrailEntityToModel(trailEntity);
//            userTrails.add(trail);
//        }
//        modelAndView.addObject("myTrails", userTrails);

        // get user collected trails by user id
//        List<Integer> userCompletedTrails = trailRepository.getCompletedTrailsByUserId(1);
//        List<Trail> completedTrails = new ArrayList<>();
//
//        for (Integer trailId : userCompletedTrails) {
//            Trail trail = trailService.getTrailById(trailId);
//            completedTrails.add(trail);
//        }
//        modelAndView.addObject("completedTrails", completedTrails);

        return modelAndView;
    }

    @GetMapping("/myaccount/user/{userId}")
    public ModelAndView myaccountUser(@PathVariable("userId") int userId) {
        ModelAndView modelAndView = new ModelAndView("myaccount.html");
        modelAndView.addObject("userId", userId);
        modelAndView.addObject("user", userService.getUserById(userId));
        return modelAndView;
    }

    @GetMapping("/myaccount/myTrails/{userid}")
    public ModelAndView myTrailsPage(@PathVariable int userid) {
        ModelAndView modelAndView = new ModelAndView("myaccount.html");

        List<TrailEntity> userTrails1 = trailRepository.getTrailsByUserId(userid);
        List<Trail> userTrails = new ArrayList<>();
        for (TrailEntity trailEntity : userTrails1) {
            Trail trail = trailService.transferTrailEntityToModel(trailEntity);
            userTrails.add(trail);
        }
        modelAndView.addObject("myTrails", userTrails);
        return modelAndView;
    }


    @GetMapping("/myaccount/completedTrails/{userid}")
    public ModelAndView completedTrailsPage(@PathVariable int userid) {
        ModelAndView modelAndView = new ModelAndView("myaccount.html");

        List<Integer> userCompletedTrails = trailRepository.getCompletedTrailsByUserId(userid);
        List<Trail> completedTrails = new ArrayList<>();

        for (Integer trailId : userCompletedTrails) {
            Trail trail = trailService.getTrailById(trailId);
            completedTrails.add(trail);
        }
        modelAndView.addObject("completedTrails", completedTrails);
        return modelAndView;
    }


    @GetMapping("/myaccount/collects/{userid}")
    public ModelAndView collectsPage(@PathVariable int userid) {
        ModelAndView modelAndView = new ModelAndView("myaccount.html");

        List<TrailEntity> userCollects1 = trailRepository.getCollectedTrailsByUserId(userid);
        List<Trail> userCollects = new ArrayList<>();
        for (TrailEntity trailEntity : userCollects1) {
            Trail trail = trailService.transferTrailEntityToModel(trailEntity);
            userCollects.add(trail);
        }
        modelAndView.addObject("collects", userCollects);
        return modelAndView;
    }


    @Autowired
    public MyAccountController(UserService userService,CheckpointRepository checkpointRepository, TrailService trailService, TrailRepository trailRepository) {
        this.checkpointRepository = checkpointRepository;
        this.trailRepository = trailRepository;
        this.trailService = trailService;
        this.userService = userService;
    }
}

