package org.sid.secservice.service;

import org.sid.secservice.entities.Circuit;
import org.sid.secservice.entities.PlantSection;
import org.sid.secservice.entities.Station;

import java.util.List;

public interface StationService {
    Station addNewStation(Station station);
    List<Station> listStation();
    public Station updateStation(Station station);
    public void removeStation(Long id);
    Station findStationByrefRegion(String refRegion);
}
