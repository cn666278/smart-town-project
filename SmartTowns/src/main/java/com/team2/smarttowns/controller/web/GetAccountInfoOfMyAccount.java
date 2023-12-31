package com.team2.smarttowns.controller.web;

import com.team2.smarttowns.dao.UserRepository;
import com.team2.smarttowns.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class GetAccountInfoOfMyAccount {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/getUserInfo")
    public UserEntity getUserInfo(@RequestBody String account) {
        return userRepository.getUserByAccount(account);
    }
}