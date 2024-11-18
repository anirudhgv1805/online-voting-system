package com.onlinevotingsystem.app.services;

import com.onlinevotingsystem.app.models.User;
import java.util.HashMap;
import java.util.Map;

public class UserService {

    // In-memory user store (username -> user object)
    private Map<String, User> users = new HashMap<>();

    // Register a new user
    public boolean registerUser(String registerNo, String name, String password) {
        if (users.containsKey(registerNo)) {
            return false; // User already exists
        }
        users.put(registerNo, new User(registerNo, name, password));
        return true;
    }

    // Login and validate user
    public boolean loginUser(String registerNo, String password) {
        User user = users.get(registerNo);
        return user != null && user.getPassword().equals(password);
    }
}
