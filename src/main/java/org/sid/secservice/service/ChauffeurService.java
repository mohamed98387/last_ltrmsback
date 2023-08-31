package org.sid.secservice.service;

import org.sid.secservice.entities.Agence;
import org.sid.secservice.entities.Chauffeur;

import java.util.List;

public interface ChauffeurService {
    Chauffeur addNewChauffeur(Chauffeur chauffeur);
    List<Chauffeur> listChauffeur();
    public Chauffeur updateChauffeur(Chauffeur chauffeur);
    public void removeChauffeur(Long id);
    Chauffeur findChauffeurBynom(String nom);
}
