package com.omarfonsek.apisistemavotacion.service;

import com.omarfonsek.apisistemavotacion.model.Candidate;
import com.omarfonsek.apisistemavotacion.model.Vote;
import com.omarfonsek.apisistemavotacion.model.Voter;
import com.omarfonsek.apisistemavotacion.repository.CandidateRepository;
import com.omarfonsek.apisistemavotacion.repository.VoteRepository;
import com.omarfonsek.apisistemavotacion.repository.VoterRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class VoteService {

    private final VoteRepository voteRepository;
    private final VoterRepository voterRepository;
    private final CandidateRepository candidateRepository;

    public VoteService(VoteRepository voteRepository, VoterRepository voterRepository, CandidateRepository candidateRepository) {
        this.voteRepository = voteRepository;
        this.voterRepository = voterRepository;
        this.candidateRepository = candidateRepository;
    }

    public String registerVote(
            Integer voterId,
            Integer candidateId
    ){
        if (voteRepository.existsByVoterId_Id(voterId)) {
            throw new IllegalStateException("El votante ya emitió su voto");
        }
        Voter voter = voterRepository.findById(voterId)
                .orElseThrow(() -> new RuntimeException("Votante no encontrado"));

        Candidate candidate = candidateRepository.findById(candidateId)
                .orElseThrow(() -> new RuntimeException("Candidato no encontrado"));

        if(voter.getId() != candidate.getId() || voter.getName() != candidate.getName()) {
            Vote vote = new Vote();
            vote.setVoterId(voter);
            vote.setCandidateId(candidate);

            voteRepository.save(vote);

            return "Voto registrado Correctamente";
        }
        else{
            return "No está habilitado para votar";
        }
    }

    public Map<String, Object> getTotalVoters() {
        List<Vote> votes = voteRepository.findAll();

        Map<Candidate, Long> votosPorCandidato = votes.stream()
                .collect(Collectors.groupingBy(
                        Vote::getCandidateId,
                        Collectors.counting()
                ));

        List<Map<String, Object>> resultados = votosPorCandidato.entrySet().stream()
                .map(entry -> {
                    Map<String, Object> resultado = new HashMap<>();
                    resultado.put("candidateId", entry.getKey().getId());
                    resultado.put("candidateName", entry.getKey().getName());
                    resultado.put("candidateParty", entry.getKey().getParty());
                    resultado.put("voteCount", entry.getValue());
                    return resultado;
                })

                .sorted((a, b) -> Long.compare(
                        (Long) b.get("voteCount"),
                        (Long) a.get("voteCount")
                ))
                .collect(Collectors.toList());


        Map<String, Object> response = new HashMap<>();
        response.put("totalVotes", votes.size());
        response.put("candidateCount", votosPorCandidato.size());
        response.put("results", resultados);

        return response;
    }

    public Map<String, Object> getStatistics() {

        List<Vote> votes = voteRepository.findAll();
        Long totalVotos = (long) votes.size();


        Long totalVotantesQueVotaron = votes.stream()
                .map(vote -> vote.getVoterId().getId())
                .distinct()
                .count();


        Long totalVotantesRegistrados = voterRepository.count();


        Map<Candidate, Long> votosPorCandidato = votes.stream()
                .collect(Collectors.groupingBy(
                        Vote::getCandidateId,
                        Collectors.counting()
                ));


        List<Map<String, Object>> estadisticasPorCandidato = votosPorCandidato.entrySet().stream()
                .map(entry -> {
                    Map<String, Object> stats = new HashMap<>();
                    Long votosCandidato = entry.getValue();


                    double porcentaje = totalVotos > 0 ?
                            (votosCandidato * 100.0) / totalVotos : 0.0;

                    stats.put("candidateId", entry.getKey().getId());
                    stats.put("candidateName", entry.getKey().getName());
                    stats.put("candidateParty", entry.getKey().getParty());
                    stats.put("totalVotes", votosCandidato);
                    stats.put("percentage", Math.round(porcentaje * 100.0) / 100.0); // 2 decimales

                    return stats;
                })

                .sorted((a, b) -> Long.compare(
                        (Long) b.get("totalVotes"),
                        (Long) a.get("totalVotes")
                ))
                .collect(Collectors.toList());


        double porcentajeParticipacion = totalVotantesRegistrados > 0 ?
                (totalVotantesQueVotaron * 100.0) / totalVotantesRegistrados : 0.0;


        Map<String, Object> estadisticas = new HashMap<>();
        estadisticas.put("totalVotes", totalVotos);
        estadisticas.put("totalVotersWhoVoted", totalVotantesQueVotaron);
        estadisticas.put("totalRegisteredVoters", totalVotantesRegistrados);
        estadisticas.put("participationPercentage", Math.round(porcentajeParticipacion * 100.0) / 100.0);
        estadisticas.put("candidateCount", votosPorCandidato.size());
        estadisticas.put("candidateStatistics", estadisticasPorCandidato);

        return estadisticas;
    }
}
