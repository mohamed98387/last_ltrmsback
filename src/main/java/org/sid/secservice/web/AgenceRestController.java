package org.sid.secservice.web;

import org.sid.secservice.entities.Agence;
import org.sid.secservice.entities.PlantSection;
import org.sid.secservice.repo.AgenceRepository;
import org.sid.secservice.repo.PlantSectionRepository;
import org.sid.secservice.service.AgenceService;
import org.sid.secservice.service.PlantSectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AgenceRestController {
    private AgenceService agenceService;
    private AgenceRepository AgenceRepository;

    public AgenceRestController(AgenceService agenceService) {
        this.agenceService = agenceService;
    }

    public AgenceRestController(org.sid.secservice.repo.AgenceRepository agenceRepository) {
        AgenceRepository = agenceRepository;
    }
@Autowired
    public AgenceRestController(AgenceService agenceService, org.sid.secservice.repo.AgenceRepository agenceRepository) {
        this.agenceService = agenceService;
        AgenceRepository = agenceRepository;
    }
    @PostMapping(path = "/addagence")
    public Agence saveAgence (@RequestBody Agence agence) {
        return agenceService.addNewAgence(agence);
    }
    @GetMapping(path = "/agences")
    public List<Agence> Agences() {
        return agenceService.listAgence();
    }
    @PutMapping("/update-agence")
    public Agence updateAgence(@RequestBody Agence agence) {
        Agence agencesaved= agenceService.updateAgence(agence);
        return agencesaved;
    }
    @DeleteMapping("/remove-agence/{agence-id}")
    public void removeAgence(@PathVariable("agence-id") Long id) {
        agenceService.removeAgence(id);
    }
    @GetMapping(path = "/getAgencebynom/{nom}")
    public Agence getAgencebynom(@PathVariable("nom") String nom) {
        return agenceService.findAgenceBynom(nom);
    }
}
