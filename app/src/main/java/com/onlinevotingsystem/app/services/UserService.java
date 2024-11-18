package com.onlinevotingsystem.app.services;

import com.onlinevotingsystem.app.models.User;
import com.onlinevotingsystem.app.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Register a new user
    public boolean registerUser(String registerNo, String name, String password) {
        // Check if a user with the same registerNo already exists
        if (userRepository.findByRegisterNo(registerNo) != null) {
            return false; // User already exists
        }
        // Create and save a new user
        User newUser = new User(registerNo, name, password);
        System.out.println(newUser);
        userRepository.save(newUser);
        return true;
    }

    // Login and validate user
    public boolean loginUser(String registerNo, String password) {
        User user = userRepository.findByRegisterNo(registerNo);
        return user != null && user.getPassword().equals(password);
    }
}
