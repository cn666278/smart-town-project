package com.team2.smarttowns.controller;

import com.team2.smarttowns.dao.CheckpointRepository;
import com.team2.smarttowns.entity.CheckpointEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CheckpointController {
    @Autowired
    private CheckpointRepository checkpointRepository;

    @GetMapping("/checkpoint/{id}")
    public ModelAndView checkpointPage(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("checkpoint.html");
        for (CheckpointEntity checkpoint : checkpointRepository.getAllCheckpoints()) {
            if (checkpoint.getId() == id) {
                modelAndView.addObject("id", checkpoint.getId());
                modelAndView.addObject("name", checkpoint.getName());
                modelAndView.addObject("img", checkpoint.getImage());
                modelAndView.addObject("description", checkpoint.getDescription());
                modelAndView.addObject("contact", checkpoint.getContact());
            }
        }
        return modelAndView;
    }

    @PostMapping("/checkpoint/{checkpointId}/{userId}")
    public void finishCheckpoint(@PathVariable int checkpointId, @PathVariable int userId) {
        checkpointRepository.addUserCheckpoint(checkpointId, userId);
    }
}
