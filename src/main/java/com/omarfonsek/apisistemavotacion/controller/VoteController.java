package com.omarfonsek.apisistemavotacion.controller;


import com.omarfonsek.apisistemavotacion.dto.VoteRequest;
import com.omarfonsek.apisistemavotacion.service.VoteService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/v1/votes")
public class VoteController {

    private final VoteService voteService;

    public VoteController(VoteService voteService) {
        this.voteService = voteService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public String registerVote(@RequestBody VoteRequest request) {
        return voteService.registerVote(request.getVoterId(), request.getCandidateId());
    }

    @GetMapping
    public Map<String, Object> getTotalVoters(){
        return voteService.getTotalVoters();
    }

    @GetMapping("/statistics")
    public ResponseEntity<Map<String, Object>> getStaticsVotes() {
        Map<String, Object> resultados = voteService.getStatistics();
        return ResponseEntity.ok(resultados);
    }
}
