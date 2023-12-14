package com.team2.smarttowns.controller.web;

import com.team2.smarttowns.dao.TownRepository;
import com.team2.smarttowns.entity.TownEntity;
import com.team2.smarttowns.service.TownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TownsController {

    TownService townService;

    @GetMapping("/towns")
    public ModelAndView townsPage() {
        ModelAndView modelAndView = new ModelAndView("towns.html");
        modelAndView.addObject("towns", townService.getAllTowns());
        return modelAndView;
    }

    @Autowired
    public TownsController(TownService townService) {
        this.townService = townService;
    }
}
