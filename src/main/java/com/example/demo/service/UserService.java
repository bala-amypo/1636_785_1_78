package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.security.core.Authentication;

public interface UserService {
    String registerUser(User user);
    String loginUser(String username, String password);
}