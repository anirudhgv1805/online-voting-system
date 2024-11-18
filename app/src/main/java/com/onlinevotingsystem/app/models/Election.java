package com.onlinevotingsystem.app.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "election") 
public class Election {

    @Id
    private String id;

    private String question;
    private int yesVotes;
    private int noVotes;

    public Election(){}
    // Constructor
    public Election(String question) {
        this.question = question;
        this.yesVotes = 0;
        this.noVotes = 0;
    }

    // Getters and Setters
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getYesVotes() {
        return yesVotes;
    }

    public void incrementYesVotes() {
        this.yesVotes++;
    }

    public int getNoVotes() {
        return noVotes;
    }

    public void incrementNoVotes() {
        this.noVotes++;
    }
}
