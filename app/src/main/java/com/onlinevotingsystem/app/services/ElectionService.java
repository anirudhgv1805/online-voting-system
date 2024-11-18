package com.onlinevotingsystem.app.services;

import com.onlinevotingsystem.app.models.Election;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ElectionService {

    // In-memory list of elections
    private List<Election> elections = new ArrayList<>();

    // Create a new election
    public void createElection(String question) {
        elections.add(new Election(question));
    }

    // Get the list of all elections
    public List<Election> getAllElections() {
        return elections;
    }

    // Vote in an election
    public void vote(String question, boolean voteYes) {
        for (Election election : elections) {
            if (election.getQuestion().equals(question)) {
                if (voteYes) {
                    election.incrementYesVotes();
                } else {
                    election.incrementNoVotes();
                }
            }
        }
    }
}
