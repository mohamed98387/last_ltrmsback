package org.sid.secservice.web;

import org.sid.secservice.entities.Permission;
import org.sid.secservice.entities.PlantSection;
import org.sid.secservice.repo.PermissionRepository;
import org.sid.secservice.repo.PlantSectionRepository;
import org.sid.secservice.service.PermissionService;
import org.sid.secservice.service.PlantSectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlantSectionRestController {
    private PlantSectionService plantSectionService;
    private PlantSectionRepository plantSectionRepository;

    public PlantSectionRestController(PlantSectionService plantSectionService) {
        this.plantSectionService = plantSectionService;
    }

    public PlantSectionRestController(PlantSectionRepository plantSectionRepository) {
        this.plantSectionRepository = plantSectionRepository;
    }

    @Autowired
    public PlantSectionRestController(PlantSectionService plantSectionService, PlantSectionRepository plantSectionRepository) {
        this.plantSectionService = plantSectionService;
        this.plantSectionRepository = plantSectionRepository;
    }

    @PostMapping(path = "/addplantSection")
    public PlantSection savePlantSection (@RequestBody PlantSection plantSection) {
        return plantSectionService.addNewPlantSection(plantSection);
    }
    @GetMapping(path = "/plantSections")
    public List<PlantSection> PlantSections() {
        return plantSectionService.listPlantSection();
    }
    @PutMapping("/update-plantSection")
    public PlantSection updatePlantSection(@RequestBody PlantSection plantSection) {
        PlantSection plantSectionsaved= plantSectionService.updatePlantSection(plantSection);
        return plantSectionsaved;
    }
    @DeleteMapping("/remove-plantSection/{plantSection-id}")
    public void removePlantSection(@PathVariable("plantSection-id") Long id) {
        plantSectionService.removePlantSection(id);
    }
    @GetMapping(path = "/getPlantSectionbyname/{nomPs}")
    public PlantSection getPlantSectionbyname(@PathVariable("nomPs") String nomPs) {
        return plantSectionService.findPlantSectionBynomPs(nomPs);
    }
}
