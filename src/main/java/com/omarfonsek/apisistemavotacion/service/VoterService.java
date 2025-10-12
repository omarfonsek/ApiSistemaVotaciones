package com.omarfonsek.apisistemavotacion.service;

import com.omarfonsek.apisistemavotacion.model.Voter;
import com.omarfonsek.apisistemavotacion.repository.VoterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoterService {

    private final VoterRepository voterRepository;

    public VoterService(
            VoterRepository voterRepository
    ) {
        this.voterRepository = voterRepository;
    }

    public List<Voter> getAllVoters() {
        return voterRepository.findAll();
    }

    public Voter getVoterById(
            Integer id
    ) {
        return voterRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        id + "no encontrada"));
    }

    public String insertVoter(
            Voter voter
    ) {
        try{
            voterRepository.save(voter);
            return "Se grabó el votante con id: " + voter.getId();
        }
        catch(Exception ex){
            return ex.getMessage();
        }

    }

    public String deleteVoter(Integer id) {
        try{
            if (voterRepository.existsById(id)){
                voterRepository.deleteById(id);
                return "Votante eliminado exitosamente";
            }
            else{
                return "Votante con id: " + id + " no encontrado";
            }

        }
        catch (Exception ex){
            return ex.getMessage();
        }

    }
}
