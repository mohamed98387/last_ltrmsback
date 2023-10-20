package org.sid.secservice.web;

import org.sid.secservice.entities.FinalPlanificationTransport;
import org.sid.secservice.entities.PlanificationTransport;
import org.sid.secservice.service.FinalPlanificationTransportService;
import org.sid.secservice.service.PlanificationTransportService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FinalPlanificationTransportRestController {
    private FinalPlanificationTransportService finalPlanificationTransportService;

    public FinalPlanificationTransportRestController(FinalPlanificationTransportService finalPlanificationTransportService) {
        this.finalPlanificationTransportService = finalPlanificationTransportService;
    }

    @GetMapping(path = "/newlPlanificationTransport")
    public List<FinalPlanificationTransport> newlPlanificationTransport () {
        return this.finalPlanificationTransportService.newlPlanificationTransport();
    }
}
