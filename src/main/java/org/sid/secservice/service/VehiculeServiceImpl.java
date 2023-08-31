package org.sid.secservice.service;

import org.sid.secservice.entities.Agence;
import org.sid.secservice.entities.PlantSection;
import org.sid.secservice.entities.Vehicule;
import org.sid.secservice.repo.AgenceRepository;
import org.sid.secservice.repo.VehiculeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class VehiculeServiceImpl implements VehiculeService{
    private VehiculeRepository vehiculeRepository;
    private AgenceRepository agenceRepository;

    public VehiculeServiceImpl(AgenceRepository agenceRepository) {
        this.agenceRepository = agenceRepository;
    }

    public VehiculeServiceImpl(VehiculeRepository vehiculeRepository) {
        this.vehiculeRepository = vehiculeRepository;
    }

    @Autowired
    public VehiculeServiceImpl(VehiculeRepository vehiculeRepository, AgenceRepository agenceRepository) {
        this.vehiculeRepository = vehiculeRepository;
        this.agenceRepository = agenceRepository;
    }

    @Override
    public Vehicule addNewVehicule(Vehicule vehicule) {

        Agence agence = this.agenceRepository.findAgenceBynom(vehicule.getAgence().getNom());
            vehicule.setAgence(agence); // Associate the found agency with the vehicle
            return this.vehiculeRepository.save(vehicule);


    }

    @Override
    public List<Vehicule> listVehicule() {
        return vehiculeRepository.findAll();
    }

    @Override
    public Vehicule updateVehicule(Vehicule vehicule) {

     //   Agence agence = this.agenceRepository.findAgenceBynom(vehicule.getAgence().getNom());
    //    vehicule.setAgence(agence);
    //    System.out.println(agence);
        return (Vehicule) vehiculeRepository.save(vehicule);
    }

    @Override
    public void removeVehicule(Long id) {
        vehiculeRepository.deleteById(id);
    }
}
