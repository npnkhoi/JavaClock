package com.example.javaclockbackend.controller;

import com.example.javaclockbackend.entity.User;
import com.example.javaclockbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/home")
    public String home() {
        return "Welcome to Java Clock!";
    }

    @PostMapping("/register")
    public String createUser(@RequestBody User user) {
        System.out.println(user.getUsername());
        userRepository.save(user);
        return "Success";
    }
}
