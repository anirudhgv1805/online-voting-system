package com.onlinevotingsystem.app.controllers;

import com.onlinevotingsystem.app.services.UserService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService = new UserService();

    // Registration endpoint
    @PostMapping("/register")
    public String register(@RequestParam String registerNo, @RequestParam String name, @RequestParam String password) {
        boolean isRegistered = userService.registerUser(registerNo, name, password);
        if (isRegistered) {
            return "User registered successfully";
        } else {
            return "User already exists";
        }
    }

    // Login endpoint
    @PostMapping("/login")
    public String login(@RequestParam String registerNo, @RequestParam String password) {
        boolean isLoggedIn = userService.loginUser(registerNo, password);
        if (isLoggedIn) {
            return "Login successful";
        } else {
            return "Invalid register number or password";
        }
    }
}
