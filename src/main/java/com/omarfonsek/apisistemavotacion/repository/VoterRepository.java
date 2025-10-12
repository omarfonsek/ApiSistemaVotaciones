package com.omarfonsek.apisistemavotacion.repository;

import com.omarfonsek.apisistemavotacion.model.Voter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoterRepository
        extends JpaRepository<Voter, Integer> {
}
