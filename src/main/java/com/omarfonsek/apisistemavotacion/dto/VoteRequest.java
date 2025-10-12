package com.omarfonsek.apisistemavotacion.dto;

public class VoteRequest {
    private Integer voterId;
    private Integer candidateId;

    public VoteRequest() {}

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
}
