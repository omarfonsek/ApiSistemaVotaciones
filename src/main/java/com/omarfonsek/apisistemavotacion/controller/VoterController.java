package com.omarfonsek.apisistemavotacion.controller;

import com.omarfonsek.apisistemavotacion.model.Voter;
import com.omarfonsek.apisistemavotacion.service.VoterService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/voters")
public class VoterController {

    private final VoterService voterService;

    public VoterController(VoterService voterService) {
        this.voterService = voterService;
    }

    @GetMapping
    public List<Voter> getVoters(){
        return voterService.getAllVoters();
    }

    @GetMapping("{id}")
    public Voter getVoterById(
            @PathVariable Integer id
    ){
        return voterService.getVoterById(id);
    }

    @PostMapping
    public String addNewVoter(
            @RequestBody Voter voter
    ){
        return voterService.insertVoter(voter);
    }

    @DeleteMapping("{id}")
    public String deleteVoter(
            @PathVariable Integer id
    ){
        return voterService.deleteVoter(id);
    }
}
