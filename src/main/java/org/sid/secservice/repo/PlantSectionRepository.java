package org.sid.secservice.repo;

import org.sid.secservice.entities.Permission;
import org.sid.secservice.entities.PlantSection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantSectionRepository  extends JpaRepository<PlantSection,Long> {
}
