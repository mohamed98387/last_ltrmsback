package org.sid.secservice.repo;

import org.sid.secservice.entities.Agence;
import org.sid.secservice.entities.Chauffeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChauffeurRepository extends JpaRepository<Chauffeur,Long> {
    Chauffeur findChauffeurBynom(String nom);
}
