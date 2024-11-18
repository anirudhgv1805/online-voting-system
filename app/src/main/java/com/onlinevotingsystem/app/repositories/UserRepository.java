package com.onlinevotingsystem.app.repositories;

import com.onlinevotingsystem.app.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findByRegisterNo(String registerNo);  // Find user by registerNo
}
