package org.sid.secservice.web;

import org.sid.secservice.entities.Agence;
import org.sid.secservice.entities.Chauffeur;
import org.sid.secservice.repo.AgenceRepository;
import org.sid.secservice.repo.ChauffeurRepository;
import org.sid.secservice.service.AgenceService;
import org.sid.secservice.service.ChauffeurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ChauffeurRestController {
    private ChauffeurService chauffeurService;
    private ChauffeurRepository chauffeurRepository;

    public ChauffeurRestController(ChauffeurService chauffeurService) {
        this.chauffeurService = chauffeurService;
    }

    public ChauffeurRestController(ChauffeurRepository chauffeurRepository) {
        this.chauffeurRepository = chauffeurRepository;
    }
    @Autowired
    public ChauffeurRestController(ChauffeurService chauffeurService, ChauffeurRepository chauffeurRepository) {
        this.chauffeurService = chauffeurService;
        this.chauffeurRepository = chauffeurRepository;
    }
    @PostMapping(path = "/addchauffeur")
    public Chauffeur saveChauffeur (@RequestBody Chauffeur chauffeur) {
        return chauffeurService.addNewChauffeur(chauffeur);
    }
    @GetMapping(path = "/chauffeurs")
    public List<Chauffeur> Chauffeurs() {
        return chauffeurService.listChauffeur();
    }
    @PutMapping("/update-chauffeur")
    public Chauffeur updateChauffeur(@RequestBody Chauffeur chauffeur) {
        Chauffeur chauffeursaved= chauffeurService.updateChauffeur(chauffeur);
        return chauffeursaved;
    }
    @DeleteMapping("/remove-chauffeur/{chauffeur-id}")
    public void removeChauffeur(@PathVariable("chauffeur-id") Long id) {
        chauffeurService.removeChauffeur(id);
    }
    @GetMapping(path = "/getChauffeurbynom/{nom}")
    public Chauffeur getChauffeurbynom(@PathVariable("nom") String nom) {
        return chauffeurService.findChauffeurBynom(nom);
    }
}
