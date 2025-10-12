package com.omarfonsek.apisistemavotacion.repository;

import com.omarfonsek.apisistemavotacion.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRepository
        extends JpaRepository<Vote, Integer> {
    boolean existsByVoterId_Id(Integer voterId);
}
