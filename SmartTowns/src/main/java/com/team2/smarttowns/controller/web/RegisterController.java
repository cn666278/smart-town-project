package com.team2.smarttowns.controller.web;

import com.team2.smarttowns.entity.UserEntity;
import com.team2.smarttowns.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegisterController {
    UserService userService;
    PasswordEncoder passwordEncoder;

    public RegisterController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * register form
     * @return
     */
    @GetMapping("/register")
    public ModelAndView reviewForm() {
        ModelAndView modelAndView = new ModelAndView("registration");
        modelAndView.addObject("user", new UserEntity());
        return modelAndView;
    }

    /**
     * submit register information
     * @param user
     * @param bindingResult for validation
     * @param model
     * @return
     */
    @PostMapping("/submitRegistration")
    public ModelAndView submitRegistration(@Valid @ModelAttribute("user") UserEntity user,
                                           BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("registration", model.asMap());
            System.out.println("Errors");
            return modelAndView;
        }
        System.out.println(user);
        user.setPassword(passwordEncoder.encode(user.getPassword())); // store encoded password to database
        userService.addUser(user); // to actually add user information to database
        ModelAndView modelAndView = new ModelAndView("redirect:/login");
        return modelAndView;
    }
}
