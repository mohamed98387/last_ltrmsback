package org.sid.secservice.service;

import org.sid.secservice.entities.Agence;
import org.sid.secservice.entities.Chauffeur;
import org.sid.secservice.repo.AgenceRepository;
import org.sid.secservice.repo.ChauffeurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChauffeurServiceImpl implements ChauffeurService {
    private ChauffeurRepository chauffeurRepository;
    private AgenceRepository agenceRepository;

    public ChauffeurServiceImpl(AgenceRepository agenceRepository) {
        this.agenceRepository = agenceRepository;
    }

    public ChauffeurServiceImpl(ChauffeurRepository chauffeurRepository) {
        this.chauffeurRepository = chauffeurRepository;
    }
    @Autowired
    public ChauffeurServiceImpl(ChauffeurRepository chauffeurRepository, AgenceRepository agenceRepository) {
        this.chauffeurRepository = chauffeurRepository;
        this.agenceRepository = agenceRepository;
    }



    @Override
    public Chauffeur addNewChauffeur(Chauffeur chauffeur) {
        Agence agence = this.agenceRepository.findAgenceBynom(chauffeur.getAgence().getNom());
        chauffeur.setAgence(agence);
        return
                this.chauffeurRepository.save(chauffeur);
    }

    @Override
    public List<Chauffeur> listChauffeur() {
        return chauffeurRepository.findAll();
    }

    @Override
    public Chauffeur updateChauffeur(Chauffeur chauffeur) {
        return (Chauffeur) chauffeurRepository.save(chauffeur);
    }

    @Override
    public void removeChauffeur(Long id) {
        chauffeurRepository.deleteById(id);
    }

    @Override
    public Chauffeur findChauffeurBynom(String nom) {
        return chauffeurRepository.findChauffeurBynom(nom);
    }
}
