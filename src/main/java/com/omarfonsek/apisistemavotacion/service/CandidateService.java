package com.omarfonsek.apisistemavotacion.service;

import com.omarfonsek.apisistemavotacion.model.Candidate;
import com.omarfonsek.apisistemavotacion.repository.CandidateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateService {

    private final CandidateRepository candidateRepository;

    public CandidateService(
            CandidateRepository candidateRepository
    ) {
        this.candidateRepository = candidateRepository;
    }

    public List<Candidate> getAllCandidates(){
        return candidateRepository.findAll();
    }

    public Candidate getCandidateById(
            Integer id
    ) {
        return candidateRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        id + "no encontrada"));
    }

    public String insertCandidate(
            Candidate candidate
    ) {
        try{
            candidateRepository.save(candidate);
            return "Se grabó el candidato con id: " + candidate.getId();
        }
        catch(Exception ex){
            return ex.getMessage();
        }

    }

    public String deleteCandidate(Integer id) {
        try{
            if (candidateRepository.existsById(id)){
                candidateRepository.deleteById(id);
                return "Candidato eliminado exitosamente";
            }
            else{
                return "Candidato con id: " + id + " no encontrado";
            }

        }
        catch (Exception ex){
            return ex.getMessage();
        }

    }
}
