// model/Vote.java
package com.example.VotingApplication.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "votes")
public class Vote {
    @Id
    private String id;
    private String voterName;
    private String candidate;

    // Constructors
    public Vote() {}

    public Vote(String voterName, String candidate) {
        this.voterName = voterName;
        this.candidate = candidate;
    }

    // Getters and Setters
    public String getId() { return id; }
    public String getVoterName() { return voterName; }
    public void setVoterName(String voterName) { this.voterName = voterName; }
    public String getCandidate() { return candidate; }
    public void setCandidate(String candidate) { this.candidate = candidate; }
}
