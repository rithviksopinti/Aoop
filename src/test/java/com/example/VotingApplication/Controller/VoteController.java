// controller/VoteController.java
package com.example.VotingApplication.Controller;

import com.example.VotingApplication.Model.Vote;
import com.example.VotingApplication.Repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/votes")
public class VoteController {

    @Autowired
    private VoteRepository voteRepository;

    // Create
    @PostMapping
    public Vote createVote(@RequestBody Vote vote) {
        return voteRepository.save(vote);
    }

    // Read All
    @GetMapping
    public List<Vote> getAllVotes() {
        return voteRepository.findAll();
    }

    // Read One
    @GetMapping("/{id}")
    public Optional<Vote> getVoteById(@PathVariable String id) {
        return voteRepository.findById(id);
    }

    // Update
    @PutMapping("/{id}")
    public Vote updateVote(@PathVariable String id, @RequestBody Vote updatedVote) {
        return voteRepository.findById(id).map(vote -> {
            vote.setVoterName(updatedVote.getVoterName());
            vote.setCandidate(updatedVote.getCandidate());
            return voteRepository.save(vote);
        }).orElse(null);
    }

    // Delete
    @DeleteMapping("/{id}")
    public void deleteVote(@PathVariable String id) {
        voteRepository.deleteById(id);
    }
}
