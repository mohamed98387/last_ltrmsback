package org.sid.secservice.web;

import org.sid.secservice.entities.Employe;
import org.sid.secservice.entities.PlanificationProduction;
import org.sid.secservice.entities.PlantSection;
import org.sid.secservice.service.EmployeeService;
import org.sid.secservice.service.PlanificationProductionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class PlanificationProductionController {
    private PlanificationProductionService planificationProductionService;

    public PlanificationProductionController(PlanificationProductionService planificationProductionService) {
        this.planificationProductionService = planificationProductionService;
    }
    @GetMapping(path = "/planificationProductions")
    public List<PlanificationProduction> employees() {
        return planificationProductionService.listPlanificationProductions();
    }
    @PostMapping("/import-planificationProductions")
    public ResponseEntity<String> importplanificationProductions(@RequestParam("planning_import_template_1696681355167") MultipartFile file, @RequestParam("semaine") String semaine ) {
        System.out.println("Selected semaine: " + semaine);
        try {
            planificationProductionService.importPlanificationFromExcel(file,semaine);
            return ResponseEntity.ok().body("{\"message\": \"planificationProductions imported successfully.\"}");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error importing planificationProductions: " + e.getMessage());
        }
    }
}
