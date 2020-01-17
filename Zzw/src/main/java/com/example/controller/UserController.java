package com.example.controller;

import com.example.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping("login")
    public String login(){
        return "aaaaaaaa";
    }
}
