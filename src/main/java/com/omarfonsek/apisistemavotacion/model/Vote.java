package com.omarfonsek.apisistemavotacion.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "voter_id")
    private Voter voterId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "candidate_id")
    private Candidate candidateId;

    public Vote(){}

    public Vote(Integer id, Voter voterId, Candidate candidateId) {
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

    public Voter getVoterId() {
        return voterId;
    }

    public void setVoterId(Voter voterId) {
        this.voterId = voterId;
    }

    public Candidate getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Candidate candidateId) {
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
