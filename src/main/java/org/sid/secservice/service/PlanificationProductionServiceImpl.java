package org.sid.secservice.service;

import org.apache.poi.ss.usermodel.*;
import org.sid.secservice.entities.*;
import org.sid.secservice.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class PlanificationProductionServiceImpl implements PlanificationProductionService {
    private RecapRepository recapRepository;
    private PlanificationProductionRepository planificationProductionRepository;
    private PlantSectionRepository plantSectionRepository;
    private EmployeRepository employeRepository;

    public PlanificationProductionServiceImpl(RecapRepository recapRepository) {
        this.recapRepository = recapRepository;
    }

    public PlanificationProductionServiceImpl(PlanificationProductionRepository planificationProductionRepository) {
        this.planificationProductionRepository = planificationProductionRepository;
    }

    public PlanificationProductionServiceImpl(PlantSectionRepository plantSectionRepository) {
        this.plantSectionRepository = plantSectionRepository;
    }
    @Autowired
    public PlanificationProductionServiceImpl(RecapRepository recapRepository, PlanificationProductionRepository planificationProductionRepository, PlantSectionRepository plantSectionRepository, EmployeRepository employeRepository) {
        this.recapRepository = recapRepository;
        this.planificationProductionRepository = planificationProductionRepository;
        this.plantSectionRepository = plantSectionRepository;
        this.employeRepository = employeRepository;
    }









    @Override
    public void importPlanificationFromExcel(MultipartFile file,String semaine) throws IOException {
        try (Workbook workbook = WorkbookFactory.create(file.getInputStream())) {
            Sheet sheet = workbook.getSheetAt(0); // Assuming the first sheet contains the employee data
            Iterator<Row> rowIterator = sheet.iterator();
            LocalDateTime currentDateTime = LocalDateTime.now();
            List<PlanificationProduction> planificationProductions = new ArrayList<>();
            List<Recap> recaps = new ArrayList<>();
            if (rowIterator.hasNext()) {
                rowIterator.next();
            }
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();

                // Assuming the data is present in the first three columns (you can adjust this based on your Excel format)
                Cell matricule = row.getCell(0);
                Cell collaborateur = row.getCell(1);
                Cell samedi = row.getCell(2);
                Cell Dimanche = row.getCell(3);
                Cell Lundi = row.getCell(4);
                Cell Mardi = row.getCell(5);
                Cell Mercredi = row.getCell(6);
                Cell Jeudi = row.getCell(7);
                Cell vendredi = row.getCell(8);

                long samediPlan = 0;
                long DimanchePlan = 0;
                long      LundiPlan = 0;
                long MardiPlan = 0;
                long MercrediPlan = 0;
                long JeudiPlan = 0;
                long vendrediPlan = 0;
                long matriculePlan = 0;
                if (matricule != null && collaborateur != null && samedi != null && Dimanche != null
                        && Mardi != null&& Mercredi != null&& Jeudi != null&& vendredi != null) {

                    String collaborateurPlan = collaborateur.getStringCellValue();

                    // Check if Samedi is "repos"
                    if (samedi.getCellType() == CellType.STRING) {

                        String samediValue = samedi.getStringCellValue();
                        if (samediValue.equalsIgnoreCase("repos")) {
                            // Assign a special numeric value for "repos"
                            samediPlan = -1;
                        }else {
                            String[] timeParts = samediValue.split(" ");
                            String[] startEndTimes = timeParts[0].split(":");
                            String startTime = startEndTimes[0] + startEndTimes[1];
                            startEndTimes = timeParts[1].split(":");
                            String endTime = startEndTimes[0] + startEndTimes[1];
                            String timeRepresentation = startTime + endTime;
                            samediPlan = Integer.parseInt(timeRepresentation);
                            String formattedsamediPlan = String.format("%08d", samediPlan);

                            samediPlan = Integer.parseInt(formattedsamediPlan);
                        }
                    }
////////////////////////////////////////////////////////////////////////////////////////////////////////
                    if (Dimanche.getCellType() == CellType.STRING) {

                        String DimancheValue = Dimanche.getStringCellValue();
                        if (DimancheValue.equalsIgnoreCase("repos")) {
                            // Assign a special numeric value for "repos"
                            DimanchePlan = -1;
                        }else {
                            String[] timeParts = DimancheValue.split(" ");
                            String[] startEndTimes = timeParts[0].split(":");
                            String startTime = startEndTimes[0] + startEndTimes[1];
                            startEndTimes = timeParts[1].split(":");
                            String endTime = startEndTimes[0] + startEndTimes[1];
                            String timeRepresentation = startTime + endTime;
                            DimanchePlan = Integer.parseInt(timeRepresentation);
                            String formattedsDimanchePlan = String.format("%08d", DimanchePlan);

                            DimanchePlan = Integer.parseInt(formattedsDimanchePlan);
                        }
                    }
////////////////////////////////////////////////////////////////////////////////////////////////////////
                    if (Lundi.getCellType() == CellType.STRING) {

                        String LundiValue = Lundi.getStringCellValue();
                        if (LundiValue.equalsIgnoreCase("repos")) {
                            // Assign a special numeric value for "repos"
                            LundiPlan = -1;
                        }else {
                            String[] timeParts = LundiValue.split(" ");
                            String[] startEndTimes = timeParts[0].split(":");
                            String startTime = startEndTimes[0] + startEndTimes[1];
                            startEndTimes = timeParts[1].split(":");
                            String endTime = startEndTimes[0] + startEndTimes[1];
                            String timeRepresentation = startTime + endTime;
                            LundiPlan = Integer.parseInt(timeRepresentation);
                            String formattedsLundiPlan = String.format("%08d", DimanchePlan);

                            LundiPlan = Integer.parseInt(formattedsLundiPlan);
                        }
                    }
////////////////////////////////////////////////////////////////////////////////////////////////////////
                    if (Mardi.getCellType() == CellType.STRING) {

                        String MardiValue = Mardi.getStringCellValue();
                        if (MardiValue.equalsIgnoreCase("repos")) {
                            // Assign a special numeric value for "repos"
                            MardiPlan = -1;
                        }else {
                            String[] timeParts = MardiValue.split(" ");
                            String[] startEndTimes = timeParts[0].split(":");
                            String startTime = startEndTimes[0] + startEndTimes[1];
                            startEndTimes = timeParts[1].split(":");
                            String endTime = startEndTimes[0] + startEndTimes[1];
                            String timeRepresentation = startTime + endTime;
                            MardiPlan = Integer.parseInt(timeRepresentation);
                            String formattedsMardiPlanPlan = String.format("%08d", MardiPlan);

                            MardiPlan = Integer.parseInt(formattedsMardiPlanPlan);
                        }
                    }
////////////////////////////////////////////////////////////////////////////////////////////////////////
                    if ( Mercredi.getCellType() == CellType.STRING) {

                        String  MercrediValue =  Mercredi.getStringCellValue();
                        if (MercrediValue.equalsIgnoreCase("repos")) {
                            // Assign a special numeric value for "repos"
                            MercrediPlan = -1;
                        }else {
                            String[] timeParts = MercrediValue.split(" ");
                            String[] startEndTimes = timeParts[0].split(":");
                            String startTime = startEndTimes[0] + startEndTimes[1];
                            startEndTimes = timeParts[1].split(":");
                            String endTime = startEndTimes[0] + startEndTimes[1];
                            String timeRepresentation = startTime + endTime;
                            MercrediPlan = Integer.parseInt(timeRepresentation);
                            String formattedsMercrediPlanPlan = String.format("%08d", MercrediPlan);

                            MercrediPlan = Integer.parseInt(formattedsMercrediPlanPlan);
                        }
                    }
 ////////////////////////////////////////////////////////////////////////////////////////////////////////
                    if ( Jeudi.getCellType() == CellType.STRING) {

                        String  JeudiValue =  Jeudi.getStringCellValue();
                        if (JeudiValue.equalsIgnoreCase("repos")) {
                            // Assign a special numeric value for "repos"
                            JeudiPlan = -1;
                        }else {
                            String[] timeParts = JeudiValue.split(" ");
                            String[] startEndTimes = timeParts[0].split(":");
                            String startTime = startEndTimes[0] + startEndTimes[1];
                            startEndTimes = timeParts[1].split(":");
                            String endTime = startEndTimes[0] + startEndTimes[1];
                            String timeRepresentation = startTime + endTime;
                            JeudiPlan = Integer.parseInt(timeRepresentation);
                            String formattedsJeudiPlanPlan = String.format("%08d", JeudiPlan);

                            JeudiPlan = Integer.parseInt(formattedsJeudiPlanPlan);
                        }
                    }
 ////////////////////////////////////////////////////////////////////////////////////////////////////////
                    if ( vendredi.getCellType() == CellType.STRING) {

                        String  vendrediValue =  vendredi.getStringCellValue();
                        if (vendrediValue.equalsIgnoreCase("repos")) {
                            // Assign a special numeric value for "repos"
                            vendrediPlan = -1;
                        }else {
                            String[] timeParts = vendrediValue.split(" ");
                            String[] startEndTimes = timeParts[0].split(":");
                            String startTime = startEndTimes[0] + startEndTimes[1];
                            startEndTimes = timeParts[1].split(":");
                            String endTime = startEndTimes[0] + startEndTimes[1];
                            String timeRepresentation = startTime + endTime;
                            vendrediPlan = Integer.parseInt(timeRepresentation);
                            String formattedsvendrediPlanlan = String.format("%08d", vendrediPlan);

                            vendrediPlan = Integer.parseInt(formattedsvendrediPlanlan);
                        }
                    }
                    // ... Rest of your existing code ...
                    if (matricule.getCellType() == CellType.NUMERIC) {
                        matriculePlan = (long) matricule.getNumericCellValue();
                    } else if (matricule.getCellType() == CellType.STRING) {
                        matriculePlan = Long.parseLong(matricule.getStringCellValue());
                    }
                   Employe employe = this.employeRepository.findEmployeByMatricule(matriculePlan);

                    PlanificationProduction planificationProduction = new PlanificationProduction(null, matriculePlan, collaborateurPlan, samediPlan, DimanchePlan, LundiPlan, MardiPlan, MercrediPlan, JeudiPlan, vendrediPlan,semaine);
                    Recap recap = new Recap( null, matriculePlan,collaborateurPlan,employe.getSegment().getCenterCoutSegment(),employe.getPs().getNomPs(),employe.getStation().getRefRegion(),employe.getStation().getRefRegion(),null,samediPlan,DimanchePlan,LundiPlan,MardiPlan,MercrediPlan,JeudiPlan,vendrediPlan,null, currentDateTime);

                    planificationProductions.add(planificationProduction);
                    recaps.add(recap);
                }
            }

            // Save the employees to the database using the employeeRepository
            planificationProductionRepository.saveAll(planificationProductions);
            this.recapRepository.saveAll(recaps);
        }
    }

    @Override
    public List<PlanificationProduction> listPlanificationProductions() {
        return planificationProductionRepository.findAll();
    }
}
