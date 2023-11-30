package com.team2.smarttowns.controller;

import com.team2.smarttowns.users.User;
import com.team2.smarttowns.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class GetAccountInfoOfMyAccount {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/getUserInfo")
    public User getUserInfo(@RequestBody String account) {
        return userRepository.getUserByAccount(account);
    }
}