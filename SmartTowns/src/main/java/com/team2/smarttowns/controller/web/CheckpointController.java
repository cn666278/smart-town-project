package com.team2.smarttowns.controller.web;

import com.team2.smarttowns.dao.CheckpointRepository;
import com.team2.smarttowns.entity.CheckpointEntity;
import com.team2.smarttowns.service.CheckpointService;
import com.team2.smarttowns.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
public class CheckpointController {
    CheckpointService checkpointService;
    UserService userService;

    @Autowired
    public CheckpointController(CheckpointService checkpointService, UserService userService) {
        this.checkpointService = checkpointService;
        this.userService = userService;
    }

    @GetMapping("/checkpoint/{id}")
    public ModelAndView checkpointPage(@PathVariable int id, Principal principal) {
        ModelAndView modelAndView = new ModelAndView("checkpoint.html");
        if (principal != null) {
            int userId = userService.getUserIdByName(principal.getName());
            modelAndView.addObject("userId", userId);
        }
        CheckpointEntity checkpoint = checkpointService.getCheckpointById(id);

        modelAndView.addObject("id", checkpoint.getId());
        modelAndView.addObject("name", checkpoint.getName());
        modelAndView.addObject("img", checkpoint.getImage());
        modelAndView.addObject("description", checkpoint.getDescription());
        modelAndView.addObject("contact", checkpoint.getContact());

        return modelAndView;
    }

    @PostMapping("/checkpoint/{checkpointId}/{userId}")
    public ModelAndView finishCheckpoint(@PathVariable int checkpointId, @PathVariable int userId) {
        checkpointService.addUserCheckpoint(checkpointId, userId);
        ModelAndView modelAndView = new ModelAndView("checkpoint.html");
        return modelAndView;
    }
}
