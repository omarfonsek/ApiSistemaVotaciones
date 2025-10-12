package com.omarfonsek.apisistemavotacion.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Voter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private boolean hasVoted = false;

    public Voter(){}

    public Voter(Integer id,
                 String name,
                 String email,
                 boolean hasVoted) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.hasVoted = hasVoted;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isHasVoted() {
        return hasVoted;
    }

    public void setHasVoted(boolean hasVoted) {
        this.hasVoted = hasVoted;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Voter voter = (Voter) o;
        return hasVoted == voter.hasVoted && Objects.equals(id, voter.id) && Objects.equals(name, voter.name) && Objects.equals(email, voter.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, hasVoted);
    }
}


