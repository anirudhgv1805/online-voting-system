package com.onlinevotingsystem.app.controllers;

import com.onlinevotingsystem.app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Register a new user
    @PostMapping("/register")
    public String registerUser(@RequestParam String registerNo, @RequestParam String name, @RequestParam String password) {
        System.out.println(name);
        boolean success = userService.registerUser(registerNo, name, password);
        return success ? "User registered successfully!" : "User already exists!";
    }

    // Login and validate user
    @PostMapping("/login")
    public String loginUser(@RequestParam String registerNo, @RequestParam String password) {
        boolean success = userService.loginUser(registerNo, password);
        return success ? "Login successful!" : "Invalid register number or password!";
    }
}
