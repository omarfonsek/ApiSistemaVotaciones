package com.omarfonsek.apisistemavotacion.controller;


import com.omarfonsek.apisistemavotacion.model.Candidate;
import com.omarfonsek.apisistemavotacion.service.CandidateService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/candidates")
public class CandidateController {

    private final CandidateService candidateService;

    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @GetMapping
    public List<Candidate> getCandidates(){
        return candidateService.getAllCandidates();
    }

    @GetMapping("{id}")
    public Candidate getCandidateById(
            @PathVariable Integer id
    ){
        return candidateService.getCandidateById(id);
    }

    @PostMapping
    public String addNewCandidate(
            @RequestBody Candidate candidate
    ){
        return candidateService.insertCandidate(candidate);
    }

    @DeleteMapping("{id}")
    public String deleteCandidate(
            @PathVariable Integer id
    ){
        return candidateService.deleteCandidate(id);
    }
}
