package org.sid.secservice.service;

import org.sid.secservice.entities.Agence;
import org.sid.secservice.entities.Chauffeur;
import org.sid.secservice.entities.Circuit;
import org.sid.secservice.repo.AgenceRepository;
import org.sid.secservice.repo.CircuitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CircuitServiceImpl implements CircuitService{
    private CircuitRepository circuitRepository;
    private AgenceRepository agenceRepository;

    public CircuitServiceImpl(CircuitRepository circuitRepository) {
        this.circuitRepository = circuitRepository;
    }

    public CircuitServiceImpl(AgenceRepository agenceRepository) {
        this.agenceRepository = agenceRepository;
    }
    @Autowired
    public CircuitServiceImpl(CircuitRepository circuitRepository, AgenceRepository agenceRepository) {
        this.circuitRepository = circuitRepository;
        this.agenceRepository = agenceRepository;
    }

    @Override
    public Circuit addNewCircuit(Circuit circuit) {
        Agence agence = this.agenceRepository.findAgenceBynom(circuit.getAgence().getNom());
        circuit.setAgence(agence);
        return
                this.circuitRepository.save(circuit);
    }

    @Override
    public List<Circuit> listCircuit() {
        return circuitRepository.findAll();
    }

    @Override
    public Circuit updateCircuit(Circuit circuit) {
        return (Circuit) circuitRepository.save(circuit);
    }

    @Override
    public void removeCircuit(Long id) {
        circuitRepository.deleteById(id);
    }

    @Override
    public Circuit findCircuitByrefChemin(String refChemin) {
        return circuitRepository.findCircuitByrefChemin(refChemin);
    }


}
