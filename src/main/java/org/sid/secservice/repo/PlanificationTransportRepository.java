package org.sid.secservice.repo;

import org.sid.secservice.entities.Permission;
import org.sid.secservice.entities.PlanificationProduction;
import org.sid.secservice.entities.PlanificationTransport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanificationTransportRepository extends JpaRepository<PlanificationTransport,Long> {

}
