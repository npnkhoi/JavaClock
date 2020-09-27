package com.example.javaclockbackend.controller;

import com.example.javaclockbackend.controller.utils.SecurityUtils;
import com.example.javaclockbackend.entity.User;
import com.example.javaclockbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

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
        if (userRepository.findByUsername(user.getUsername()).size() != 0) {
            // Duplicated username
            return "Error: Duplicated username";
            // TODO: Automate this check
        }

        // Hash the password
        String hashedPassword = SecurityUtils.hashPassword(user.getPassword());
        user.setPassword(hashedPassword);
        userRepository.save(user);
        return "Success";
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        List<User> rets;
        User ret = new User();
        if (user.getUsername() != null && user.getPassword() != null) {
            // Hash the password
            user.setPassword(SecurityUtils.hashPassword(user.getPassword()));
            rets = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());

            if (rets.size() != 0) {
                return "Welcome!";
            } else {
                return "Wrong username or password";
            }
        } else {
            return "Some field(s) are missing";
        }
    }
}
