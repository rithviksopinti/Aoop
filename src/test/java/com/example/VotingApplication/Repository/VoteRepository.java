// repository/VoteRepository.java
package com.example.VotingApplication.Repository;

import com.example.VotingApplication.Model.Vote;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VoteRepository extends MongoRepository<Vote, String> {
    // Custom query methods (optional)
}
