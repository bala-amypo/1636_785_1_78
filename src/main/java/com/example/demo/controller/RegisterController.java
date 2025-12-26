package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.security.JwtUtil;

@RestController
public class RegisterController {

    private final JwtUtil jwtUtil;

    public RegisterController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")   // EXACT path expected
    public String register(@RequestBody User user) {
        return jwtUtil.generateToken(user);
    }
}
