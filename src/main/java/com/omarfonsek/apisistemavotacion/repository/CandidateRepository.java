package com.omarfonsek.apisistemavotacion.repository;

import com.omarfonsek.apisistemavotacion.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository
        extends JpaRepository<Candidate, Integer> {
}
