package org.sid.secservice.service;

import org.sid.secservice.entities.Circuit;
import org.sid.secservice.entities.PlanificationTransport;

import java.util.List;

public interface PlanificationTransportService {

    public List<PlanificationTransport> calculPlanificationTransport(String Agence);
    public void deleteAllData();
}
