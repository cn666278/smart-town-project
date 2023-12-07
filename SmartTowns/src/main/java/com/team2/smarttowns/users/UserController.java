package com.team2.smarttowns.users;

import com.team2.smarttowns.dao.UserRepository;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @Resource
    private com.team2.smarttowns.dao.UserRepository UserRepository;

    @GetMapping("/userList")
    public String userList() {
        return "userList";
    }
}
