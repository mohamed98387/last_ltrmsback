package org.sid.secservice.repo;

import org.sid.secservice.entities.Agence;
import org.sid.secservice.entities.FinalPlanificationTransport;
import org.sid.secservice.entities.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface FinalPlanificationTransportRepository extends JpaRepository<FinalPlanificationTransport,Long> {
    FinalPlanificationTransport findFinalPlanificationTransportByid(Long id);
    FinalPlanificationTransport findFinalPlanificationTransportByjourSemaine(String jourSemaine);
   // FinalPlanificationTransport findFinalPlanificationTransportByjourSemaineAndDebutPoste(String jourSemaine,Integer debutPoste);
    FinalPlanificationTransport findFinalPlanificationTransportByjourSemaineAndDebutPosteAndAgence(String jourSemaine,Integer debutPoste,String Agence);
}
