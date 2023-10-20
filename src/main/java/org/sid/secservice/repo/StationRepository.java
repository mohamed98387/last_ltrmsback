package org.sid.secservice.repo;

import org.sid.secservice.entities.Circuit;
import org.sid.secservice.entities.PlantSection;
import org.sid.secservice.entities.Station;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StationRepository extends JpaRepository<Station,Long> {
    Station findStationByrefRegion(String refRegion);
}
