package com.example.oauth.controller;

import com.example.oauth.entity.User;
import com.example.oauth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/home")
    public String index() {
        return "Welcome to OAuth authorization";
    }

    @GetMapping("/api/users")
    public ResponseEntity<?> getAllUsers() {
        return new ResponseEntity(userRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping("/api/save")
    public ResponseEntity<?> saveUser(@RequestBody User theUser) {
        theUser.setPassword(passwordEncoder.encode(theUser.getPassword()));
        return new ResponseEntity(userRepository.save(theUser), HttpStatus.CREATED);
    }

}
