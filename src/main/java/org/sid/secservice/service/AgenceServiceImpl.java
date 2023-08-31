package org.sid.secservice.service;

import org.sid.secservice.entities.Agence;
import org.sid.secservice.entities.PlantSection;
import org.sid.secservice.repo.AgenceRepository;
import org.sid.secservice.repo.PlantSectionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AgenceServiceImpl implements AgenceService {
    private AgenceRepository agenceRepository;

    public AgenceServiceImpl(AgenceRepository agenceRepository) {
        this.agenceRepository = agenceRepository;
    }

    @Override
    public Agence addNewAgence(Agence agence) {
        return this.agenceRepository.save(agence);
    }

    @Override
    public List<Agence> listAgence() {
        return agenceRepository.findAll();
    }
    @Transactional
    @Override
    public Agence updateAgence(Agence agence) {
        return (Agence) agenceRepository.save(agence);
    }

    @Override
    public void removeAgence(Long id) {
        agenceRepository.deleteById(id);
    }

    @Override
    public Agence findAgenceBynom(String nom) {
        return agenceRepository.findAgenceBynom(nom);
    }
}
