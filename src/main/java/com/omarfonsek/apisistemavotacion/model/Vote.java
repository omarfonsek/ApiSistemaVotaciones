package com.omarfonsek.apisistemavotacion.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer voterId;
    private Integer candidateId;

    public Vote(){}

    public Vote(Integer id, Integer voterId, Integer candidateId) {
        this.id = id;
        this.voterId = voterId;
        this.candidateId = candidateId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVoterId() {
        return voterId;
    }

    public void setVoterId(Integer voterId) {
        this.voterId = voterId;
    }

    public Integer getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Integer candidateId) {
        this.candidateId = candidateId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Vote vote = (Vote) o;
        return Objects.equals(id, vote.id) && Objects.equals(voterId, vote.voterId) && Objects.equals(candidateId, vote.candidateId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, voterId, candidateId);
    }
}
