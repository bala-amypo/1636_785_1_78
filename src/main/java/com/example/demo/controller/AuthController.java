package com.example.demo.controller;

import java.util.Map;

import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.User;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthController(UserService userService,
                          AuthenticationManager authenticationManager,
                          JwtTokenProvider jwtTokenProvider) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    // ✅ REGISTER (NO TOKEN REQUIRED)
    @PostMapping("/register")
    public Map<String, Object> register(@RequestBody User user) {

        User saved = userService.register(user);

        Authentication auth =
                new UsernamePasswordAuthenticationToken(
                        saved.getEmail(),
                        user.getPassword()
                );

        String token = jwtTokenProvider.generateToken(
                auth,
                saved.getId(),
                saved.getRole()
        );

        return Map.of(
                "message", "Registration successful",
                "token", token
        );
    }

    // ✅ LOGIN (NO TOKEN REQUIRED)
    @PostMapping("/login")
    public Map<String, String> login(@RequestBody User user) {

        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getEmail(),
                        user.getPassword()
                )
        );

        User dbUser = userService.findByEmail(user.getEmail());

        String token = jwtTokenProvider.generateToken(
                auth,
                dbUser.getId(),
                dbUser.getRole()
        );

        return Map.of("token", token);
    }
}
