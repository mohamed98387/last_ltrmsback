package org.sid.secservice.web;

import org.sid.secservice.entities.Circuit;
import org.sid.secservice.entities.PlanificationTransport;
import org.sid.secservice.entities.PlantSection;
import org.sid.secservice.service.CircuitService;
import org.sid.secservice.service.PlanificationTransportService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlanificationTransportRestController {
    private PlanificationTransportService planificationTransportService;

    public PlanificationTransportRestController(PlanificationTransportService planificationTransportService) {
        this.planificationTransportService = planificationTransportService;
    }

    @GetMapping(path = "/addplanificationtransport/{agence}")
    public List<PlanificationTransport> addplanificationtransport (@PathVariable("agence") String agence) {
       return this.planificationTransportService.calculPlanificationTransport(agence);
    }
    @DeleteMapping("/clear-table-PlanficationTransport")
    public void clearTable() {
        planificationTransportService.deleteAllData();
    }

}
