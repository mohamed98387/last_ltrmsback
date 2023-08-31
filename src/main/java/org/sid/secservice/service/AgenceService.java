package org.sid.secservice.service;

import org.sid.secservice.entities.Agence;
import org.sid.secservice.entities.PlantSection;

import java.util.List;

public interface AgenceService {
    Agence addNewAgence(Agence agence);
    List<Agence> listAgence();
    public Agence updateAgence(Agence agence);
    public void removeAgence(Long id);
    Agence findAgenceBynom(String nom);
}
