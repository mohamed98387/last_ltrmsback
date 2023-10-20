package org.sid.secservice.web;

import org.sid.secservice.entities.Circuit;
import org.sid.secservice.entities.Station;
import org.sid.secservice.repo.CircuitRepository;
import org.sid.secservice.repo.StationRepository;
import org.sid.secservice.service.CircuitService;
import org.sid.secservice.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StationRestController {
    private StationService stationService;
    private StationRepository stationRepository;

    public StationRestController(StationService stationService) {
        this.stationService = stationService;
    }

    public StationRestController(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }
@Autowired
    public StationRestController(StationService stationService, StationRepository stationRepository) {
        this.stationService = stationService;
        this.stationRepository = stationRepository;
    }
    @PostMapping(path = "/addstation")
    public Station saveStation (@RequestBody Station station) {
        return stationService.addNewStation(station);
    }
    @GetMapping(path = "/stations")
    public List<Station> Stations() {
        return stationService.listStation();
    }
    @PutMapping("/update-station")
    public Station updateStation(@RequestBody Station station) {
        Station stationsaved= stationService.updateStation(station);
        return stationsaved;
    }
    @DeleteMapping("/remove-station/{station-id}")
    public void removeStation(@PathVariable("station-id") Long id) {
        stationService.removeStation(id);
    }

}
