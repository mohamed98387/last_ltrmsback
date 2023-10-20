package org.sid.secservice.repo;

import org.sid.secservice.entities.Chauffeur;
import org.sid.secservice.entities.Circuit;
import org.sid.secservice.entities.Station;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CircuitRepository extends JpaRepository<Circuit,Long> {
    Circuit findCircuitByrefChemin(String refChemin);

}
