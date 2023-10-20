package org.sid.secservice.service;

import org.sid.secservice.entities.Chauffeur;
import org.sid.secservice.entities.Circuit;

import java.util.List;

public interface CircuitService {
    Circuit addNewCircuit(Circuit circuit);
    List<Circuit> listCircuit();
    public Circuit updateCircuit(Circuit circuit);
    public void removeCircuit(Long id);
    Circuit findCircuitByrefChemin(String refChemin);
}
