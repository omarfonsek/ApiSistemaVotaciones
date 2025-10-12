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
    private boolean has_voted = false;

    public Voter(){}

    public Voter(Integer id,
                 String name,
                 String email,
                 boolean has_voted) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.has_voted = has_voted;
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

    public boolean isHas_voted() {
        return has_voted;
    }

    public void setHas_voted(boolean has_voted) {
        this.has_voted = has_voted;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Voter voter = (Voter) o;
        return has_voted == voter.has_voted && Objects.equals(id, voter.id) && Objects.equals(name, voter.name) && Objects.equals(email, voter.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, has_voted);
    }
}


