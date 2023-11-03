package org.sid.secservice.service;

import org.sid.secservice.entities.Circuit;
import org.sid.secservice.entities.FinalPlanificationTransport;
import org.sid.secservice.entities.PlanificationTransport;
import org.sid.secservice.entities.Station;

import java.util.List;

public interface FinalPlanificationTransportService {
    List<FinalPlanificationTransport> lisFinalPlanificationTransports();
    public List<FinalPlanificationTransport> newlPlanificationTransport(String agence);
    FinalPlanificationTransport findFinalPlanificationTransportByid(Long id);
    FinalPlanificationTransport findFinalPlanificationTransportByjourSemaine(String jourSemaine);
    public void deleteAllData();
}
