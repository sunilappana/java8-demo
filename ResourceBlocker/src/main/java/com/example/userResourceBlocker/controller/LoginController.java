package com.example.userresourceblocker.controller;


import com.example.userresourceblocker.domain.User;
import com.example.userresourceblocker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @Autowired
    HttpServletRequest httpServletRequest;

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/")
    public String index() {
        return "login";
    }

    @RequestMapping(value = "/login")
    public String loginPage() {
        return "login";
    }

    @RequestMapping(value = "/signUpPage")
    public String signUp() {
        return "signUp";
    }


    @RequestMapping(value = "/signUp")
    public String signUp(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String userEmail, @RequestParam String userPassword, @RequestParam String mobileNo, @RequestParam String address, Model model) {

        User user = User.builder().firstName(firstName).lastName(lastName).userEmail(userEmail).userPassword(passwordEncoder.encode(userPassword)).mobileNo(mobileNo).address(address).role("user").build();
        Integer userId = userService.registerUser(user, false, false);
        if (ObjectUtils.isEmpty(userId)) {
            model.addAttribute("errorMsg", "User already exists");
            model.addAttribute("showDiv", "true");
            return "signUp";
        }
        return "login";
    }

    @RequestMapping(value = "/accessDenied")
    public String accessDenied() {
        return "accessDenied";
    }

}
