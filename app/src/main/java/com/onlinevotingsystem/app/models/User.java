package com.onlinevotingsystem.app.models;

public class User {
    private String registerNo;
    private String name;
    private String password;

    // Constructors
    public User(String registerNo, String name, String password) {
        this.registerNo = registerNo;
        this.name = name;
        this.password = password;
    }

    // Getters and Setters
    public String getRegisterNo() {
        return registerNo;
    }

    public void setRegisterNo(String registerNo) {
        this.registerNo = registerNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
