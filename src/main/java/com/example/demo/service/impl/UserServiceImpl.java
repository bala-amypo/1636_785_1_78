package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    public UserServiceImpl(UserRepository userRepository, 
                           PasswordEncoder passwordEncoder, 
                           AuthenticationManager authenticationManager, 
                           JwtTokenProvider jwtTokenProvider) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public String registerUser(User user) {
        
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new RuntimeException("Username already taken");
        }

        
        user.setPassword(passwordEncoder.encode(user.getPassword()));

       
        userRepository.save(user);

        return "User registered successfully!";
    }

    @Override
    public String loginUser(String username, String password) {
        
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );

       
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

      
        return jwtTokenProvider.generateToken(
                authentication,
                user.getId(),
                user.getRole()
        );
    }
}