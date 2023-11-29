package com.team2.smarttowns.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrailsController {
    @GetMapping
    public String trails() {
        return "trails";
    }

}
