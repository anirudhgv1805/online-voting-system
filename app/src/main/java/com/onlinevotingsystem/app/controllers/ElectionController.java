package com.onlinevotingsystem.app.controllers;

import com.onlinevotingsystem.app.models.Election;
import com.onlinevotingsystem.app.services.ElectionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/elections")
public class ElectionController {

    private final ElectionService electionService;

    // Constructor-based dependency injection
    public ElectionController(ElectionService electionService) {
        this.electionService = electionService;
    }

    // Create election
    @PostMapping("/create")
    public String createElection(@RequestParam String question) {
        electionService.createElection(question);
        return "Election created successfully";
    }

    // Get all elections
    @GetMapping("/all")
    public List<Election> getAllElections() {
        System.out.println(electionService.getAllElections());
        return electionService.getAllElections();
    }

    // Vote in an election
    @PostMapping("/vote")
    public String vote(@RequestParam String question, @RequestParam boolean voteYes) {
        electionService.vote(question, voteYes);
        return "Vote recorded successfully";
    }
}
