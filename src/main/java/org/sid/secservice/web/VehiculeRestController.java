package org.sid.secservice.web;

import org.sid.secservice.entities.Agence;
import org.sid.secservice.entities.Vehicule;
import org.sid.secservice.repo.AgenceRepository;
import org.sid.secservice.repo.VehiculeRepository;
import org.sid.secservice.service.AgenceService;
import org.sid.secservice.service.VehiculeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VehiculeRestController {
    private VehiculeService vehiculeService;
    private VehiculeRepository vehiculeRepository;

    public VehiculeRestController(VehiculeService vehiculeService) {
        this.vehiculeService = vehiculeService;
    }

    public VehiculeRestController(VehiculeRepository vehiculeRepository) {
        this.vehiculeRepository = vehiculeRepository;
    }
    @Autowired
    public VehiculeRestController(VehiculeService vehiculeService, VehiculeRepository vehiculeRepository) {
        this.vehiculeService = vehiculeService;
        this.vehiculeRepository = vehiculeRepository;
    }
    @PostMapping(path = "/addvehicule")
    public Vehicule saveVehicule (@RequestBody Vehicule vehicule) {
        return vehiculeService.addNewVehicule(vehicule);
    }
    @GetMapping(path = "/vehicules")
    public List<Vehicule> vehicules() {
        return vehiculeService.listVehicule();
    }
    @PutMapping("/update-vehicule")
    public Vehicule updateVehicule(@RequestBody Vehicule vehicule) {
        Vehicule vehiculesaved= vehiculeService.updateVehicule(vehicule);
        return vehiculesaved;
    }
    @DeleteMapping("/remove-vehicule/{vehicule-id}")
    public void removeVehicule(@PathVariable("vehicule-id") Long id) {
        vehiculeService.removeVehicule(id);
    }

}
