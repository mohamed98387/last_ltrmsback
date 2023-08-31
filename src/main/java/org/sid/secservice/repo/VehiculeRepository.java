package org.sid.secservice.repo;

import org.sid.secservice.entities.Agence;
import org.sid.secservice.entities.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculeRepository extends JpaRepository<Vehicule,Long> {
}
