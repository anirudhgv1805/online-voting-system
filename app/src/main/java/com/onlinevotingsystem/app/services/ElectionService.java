package com.onlinevotingsystem.app.services;

import com.onlinevotingsystem.app.models.Election;
import com.onlinevotingsystem.app.repositories.ElectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ElectionService {

    private final ElectionRepository electionRepository;

    @Autowired
    public ElectionService(ElectionRepository electionRepository) {
        this.electionRepository = electionRepository;
    }

    // Create a new election
    public void createElection(String question) {
        // Check if an election with this question already exists
        Optional<Election> existingElection = electionRepository.findByQuestion(question);
        if (existingElection.isEmpty()) {
            Election election = new Election(question);
            electionRepository.save(election);  // Save to MongoDB
        } else {
            // Handle the case where the election already exists
            System.out.println("Election with this question already exists.");
        }
    }

    // Get the list of all elections
    public List<Election> getAllElections() {
        return electionRepository.findAll(); // Retrieve from MongoDB
    }

    // Vote in an election
    public void vote(String question, boolean voteYes) {
        Optional<Election> electionOptional = electionRepository.findByQuestion(question); // Custom query
        if (electionOptional.isPresent()) {
            Election election = electionOptional.get();
            if (voteYes) {
                election.incrementYesVotes();
            } else {
                election.incrementNoVotes();
            }
            electionRepository.save(election); // Save the updated election to MongoDB
        } else {
            System.out.println("Election not found for the given question: " + question);
        }
    }
}
