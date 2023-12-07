package com.team2.smarttowns.checkpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CheckpointController {
    @Autowired
    private CheckpointRepository checkpointRepository;

    @GetMapping("/checkpoint/{id}")
    public ModelAndView checkpointPage(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("checkpoint.html");
        for (Checkpoint checkpoint : checkpointRepository.getAll()) {
            if (checkpoint.getId() == id) {
                modelAndView.addObject("id", checkpoint.getId());
                modelAndView.addObject("name", checkpoint.getName());
                modelAndView.addObject("img", checkpoint.getImg());
                modelAndView.addObject("description", checkpoint.getDescription());
                modelAndView.addObject("contact", checkpoint.getContact());
            }
        }
        return modelAndView;
    }
}
