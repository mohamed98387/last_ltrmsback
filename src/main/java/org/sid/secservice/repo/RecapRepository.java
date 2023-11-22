package org.sid.secservice.repo;

import org.sid.secservice.entities.PlantSection;
import org.sid.secservice.entities.Recap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecapRepository extends JpaRepository<Recap,Long> {
}
