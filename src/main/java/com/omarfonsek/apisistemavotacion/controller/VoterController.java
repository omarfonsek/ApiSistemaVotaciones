package com.omarfonsek.apisistemavotacion.controller;

import com.omarfonsek.apisistemavotacion.model.Voter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/voters")
public class VoterController {

    @GetMapping
    public List<Voter> getVoters(){
        return List.of(
                new Voter(
                        1,
                        "Omar Fonseca",
                        "omarfonsecamontes@hotmail.com",
                        false
                ),
                new Voter(
                        2,
                        "Juan Martínez",
                        "juanmartinez1998@hotmil.com",
                        false
                )
        );
    }
}
