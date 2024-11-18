package com.onlinevotingsystem.app.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "users")  // This will map the collection name to "users" in MongoDB
public class User {

    @Id
    private String id;  // This is the unique ID for MongoDB
    private String registerNo;
    private String name;
    private String password;

    public User() {
        // Default constructor for MongoDB
    }

    public User(String registerNo, String name, String password) {
        this.registerNo = registerNo;
        this.name = name;
        this.password = password;
    }

    // Getters and setters for the fields
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
