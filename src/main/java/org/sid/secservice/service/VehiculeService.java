package org.sid.secservice.service;

import org.sid.secservice.entities.Agence;
import org.sid.secservice.entities.Vehicule;

import java.util.List;

public interface VehiculeService {
    Vehicule addNewVehicule(Vehicule vehicule);
    List<Vehicule> listVehicule();
    public Vehicule updateVehicule(Vehicule vehicule);
    public void removeVehicule(Long id);
}
