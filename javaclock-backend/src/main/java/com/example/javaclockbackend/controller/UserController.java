package com.example.javaclockbackend.controller;

import com.example.javaclockbackend.controller.utils.ResponseObject;
import com.example.javaclockbackend.controller.utils.SecurityUtils;
import com.example.javaclockbackend.entity.User;
import com.example.javaclockbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/home")
    public ResponseEntity<String> home() {
        return new ResponseEntity<>("Welcome to Java Clock!", HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        if (userRepository.findByUsername(user.getUsername()).size() != 0) {
            // Duplicated username
            return new ResponseEntity<>("Error: Duplicated username", HttpStatus.NON_AUTHORITATIVE_INFORMATION);
            // TODO: Automate this check
        }

        if (!SecurityUtils.isStrong(user.getPassword())) {
            return new ResponseEntity<>("Error: Weak password", HttpStatus.NON_AUTHORITATIVE_INFORMATION);
        }

        // Hash the password
        String hashedPassword = SecurityUtils.hashPassword(user.getPassword());
        user.setPassword(hashedPassword);
        userRepository.save(user);
        return new ResponseEntity<>("Registered Successfully", HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseObject login(@RequestBody User user) {
        ResponseObject res = new ResponseObject();
        if (user.getUsername() != null && user.getPassword() != null) {
            // Hash the password
            user.setPassword(SecurityUtils.hashPassword(user.getPassword()));

            List<User> rets;
            rets = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());

            if (rets.size() != 0) {
                User matchedUser = new User();
                matchedUser.setName(rets.get(0).getName());
                res.setPayload(matchedUser);
                res.setMessage("SUCCESS");
                res.setStatusCode(200);
            } else {
                res.setMessage("WRONG_INFO");
                res.setStatusCode(203);
            }
        } else {
            res.setMessage("MISSING_FIELD");
            res.setStatusCode(203);
        }
        return res;
    }
}
