package org.sid.secservice.repo;

import org.sid.secservice.entities.Agence;
import org.sid.secservice.entities.FinalPlanificationTransport;
import org.sid.secservice.entities.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinalPlanificationTransportRepository extends JpaRepository<FinalPlanificationTransport,Long> {
    FinalPlanificationTransport findFinalPlanificationTransportByid(Long id);
    FinalPlanificationTransport findFinalPlanificationTransportByjourSemaine(String jourSemaine);
    FinalPlanificationTransport findFinalPlanificationTransportByjourSemaineAndDebutPoste(String jourSemaine,Integer debutPoste);
}
