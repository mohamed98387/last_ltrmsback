package org.sid.secservice.repo;

import org.sid.secservice.entities.Agence;
import org.sid.secservice.entities.PlanificationProduction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanificationProductionRepository extends JpaRepository<PlanificationProduction,Long> {
}
