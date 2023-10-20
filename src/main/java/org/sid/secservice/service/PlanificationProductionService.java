package org.sid.secservice.service;

import org.sid.secservice.entities.Employe;
import org.sid.secservice.entities.PlanificationProduction;
import org.sid.secservice.entities.PlantSection;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface PlanificationProductionService {
    public void importPlanificationFromExcel(MultipartFile file, String semaine)throws IOException;
    List<PlanificationProduction> listPlanificationProductions();
}
