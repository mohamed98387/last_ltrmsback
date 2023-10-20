package org.sid.secservice.service;

import org.sid.secservice.entities.FinalPlanificationTransport;
import org.sid.secservice.entities.PlanificationTransport;
import org.sid.secservice.entities.Station;

import java.util.List;

public interface FinalPlanificationTransportService {
    public List<FinalPlanificationTransport> newlPlanificationTransport();
    FinalPlanificationTransport findFinalPlanificationTransportByid(Long id);
    FinalPlanificationTransport findFinalPlanificationTransportByjourSemaine(String jourSemaine);
}
