package com.example.controller;

import com.example.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("hello")
public class HelloController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping("hello")
    public String index(){
        return userRepository.findUserByName("zzw").getSex();
    }
}
