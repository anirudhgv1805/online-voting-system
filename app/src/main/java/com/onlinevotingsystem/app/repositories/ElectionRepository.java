package com.onlinevotingsystem.app.repositories;

import com.onlinevotingsystem.app.models.Election;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ElectionRepository extends MongoRepository<Election, String> {
    List<Election> findAll();  // Find all elections
    Optional<Election> findByQuestion(String question);
}
