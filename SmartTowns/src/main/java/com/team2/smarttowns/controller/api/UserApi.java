package com.team2.smarttowns.controller.api;

import com.google.gson.Gson;
import com.team2.smarttowns.model.User;
import com.team2.smarttowns.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApi {

    private UserService userService;
    @PostMapping("/api/updateuser")
    public String getUserById(@RequestParam(value= "userId",required = false) Integer userId,
                              @RequestParam("name") String name,
                              @RequestParam("password") String password,
//                              @RequestParam("profileImg") String profileImg,
                              @RequestParam("email") String email) {
        User user = userService.getUserById(userId);
        user.setName(name);
        user.setPassword(password);
//        user.setProfileImg(profileImg);
        user.setEmail(email);
        userService.updateUser(user);
        Gson gson = new Gson();
        return gson.toJson(user);
    }

    @GetMapping("/api/getuser")
    public String getUserById() {
        User user = userService.getUserById(1);
        Gson gson = new Gson();
        return gson.toJson(user);
    }
    @Autowired
    public UserApi(UserService userService) {
        this.userService = userService;
    }
}
