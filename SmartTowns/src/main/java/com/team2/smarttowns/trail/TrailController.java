//package com.team2.smarttowns.trail;
//
//import jakarta.annotation.Resource;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.util.List;
//
//@Controller
//public class TrailController {
//
//    @Autowired
//    private TrailRepository trailRepository;
//
//    @GetMapping("/trail/{id}")
//    public ModelAndView trailPage(@PathVariable int id) {
//        // TODO : Rename trails.html to tail.html
//        ModelAndView modelAndView = new ModelAndView("trails.html");
//        // add the list of trails to the model
//        modelAndView.addObject("trails", trail.getAllTrails());
//        // add the trail details to the model
//        for (Trail trail : trailRepository.getAllTrails()) {
//            if (trail.getId() == id) {
//                modelAndView.addObject("name", trail.getName());
//                modelAndView.addObject("image", trail.getImage());
//                modelAndView.addObject("details", trail.getDetails());
//            }
//        }
//        return modelAndView;
//    }
//}
