package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/register")
    public String register() {
        return "Register user";
    }

    @PostMapping("/login")
    public String login() {
        return "Login user";
    }
}
