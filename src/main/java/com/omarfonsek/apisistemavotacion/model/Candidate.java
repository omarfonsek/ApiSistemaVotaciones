package com.omarfonsek.apisistemavotacion.model;

import java.util.Objects;

public class Candidate {
    private Integer id;
    private String name;
    private String party;
    private int votes;

    public Candidate(){}

    public Candidate(Integer id,
                     String name,
                     String party,
                     int votes) {
        this.id = id;
        this.name = name;
        this.party = party;
        this.votes = votes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Candidate candidate = (Candidate) o;
        return votes == candidate.votes && Objects.equals(id, candidate.id) && Objects.equals(name, candidate.name) && Objects.equals(party, candidate.party);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, party, votes);
    }
}
