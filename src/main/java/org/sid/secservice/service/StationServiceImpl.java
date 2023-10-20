package org.sid.secservice.service;

import org.sid.secservice.entities.Agence;
import org.sid.secservice.entities.Circuit;
import org.sid.secservice.entities.Station;
import org.sid.secservice.repo.AgenceRepository;
import org.sid.secservice.repo.CircuitRepository;
import org.sid.secservice.repo.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StationServiceImpl implements StationService{
    private StationRepository stationRepository;
    private AgenceRepository agenceRepository;

    public StationServiceImpl(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    public StationServiceImpl(AgenceRepository agenceRepository) {
        this.agenceRepository = agenceRepository;
    }
    @Autowired
    public StationServiceImpl(StationRepository stationRepository, AgenceRepository agenceRepository) {
        this.stationRepository = stationRepository;
        this.agenceRepository = agenceRepository;
    }

    @Override
    public Station addNewStation(Station station) {

        return
                this.stationRepository.save(station);
    }

    @Override
    public List<Station> listStation() {
        return  stationRepository.findAll();
    }

    @Override
    public Station updateStation(Station station) {
        return (Station) stationRepository.save(station);
    }

    @Override
    public void removeStation(Long id) {
        stationRepository.deleteById(id);
    }

    @Override
    public Station findStationByrefRegion(String refRegion) {
        return stationRepository.findStationByrefRegion(refRegion);
    }
}
