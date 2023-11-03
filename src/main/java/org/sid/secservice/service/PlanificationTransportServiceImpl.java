package org.sid.secservice.service;

import org.sid.secservice.entities.*;
import org.sid.secservice.repo.CircuitRepository;
import org.sid.secservice.repo.EmployeRepository;
import org.sid.secservice.repo.PlanificationTransportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.List;
import javax.mail.internet.MimeMessage;
@Service
public class PlanificationTransportServiceImpl implements PlanificationTransportService  {
    private PlanificationProductionService planificationProductionService;
    private PlanificationTransportRepository planificationTransportRepository;
    private EmployeRepository employeeRepository;
    private EmployeeService employeeService;
    private StationService stationService;

    private CircuitService circuitService;
    private CircuitRepository circuitRepository;
    @Autowired
    private JavaMailSender emailSender;
    public PlanificationTransportServiceImpl(PlanificationProductionService planificationProductionService) {
        this.planificationProductionService = planificationProductionService;
    }

    public PlanificationTransportServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public PlanificationTransportServiceImpl(PlanificationTransportRepository planificationTransportRepository) {
        this.planificationTransportRepository = planificationTransportRepository;
    }

    public PlanificationTransportServiceImpl(EmployeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public PlanificationTransportServiceImpl(StationService stationService) {
        this.stationService = stationService;
    }

    public PlanificationTransportServiceImpl(CircuitService circuitService) {
        this.circuitService = circuitService;
    }

    public PlanificationTransportServiceImpl(CircuitRepository circuitRepository) {
        this.circuitRepository = circuitRepository;
    }
    @Autowired
    public PlanificationTransportServiceImpl(PlanificationProductionService planificationProductionService, PlanificationTransportRepository planificationTransportRepository, EmployeRepository employeeRepository, EmployeeService employeeService, StationService stationService, CircuitService circuitService, CircuitRepository circuitRepository) {
        this.planificationProductionService = planificationProductionService;
        this.planificationTransportRepository = planificationTransportRepository;
        this.employeeRepository = employeeRepository;
        this.employeeService = employeeService;
        this.stationService = stationService;
        this.circuitService = circuitService;
        this.circuitRepository = circuitRepository;
    }








    @Override
    public List<PlanificationTransport> calculPlanificationTransport(String agence) {
        List<PlanificationProduction> planificationProduction = this.planificationProductionService.listPlanificationProductions();
        List<PlanificationTransport> AllplanificationTransport = this.planificationTransportRepository.findAll();
        List<Employe> employes = this.employeeService.listEmployes();
        List<Circuit> circuits = this.circuitService.listCircuit();
        List<PlanificationTransport> planfications = new ArrayList<>();

        for (Circuit circuit : circuits) {
            if (circuit.getAgence() != null && circuit.getAgence().getNom().equals(agence)) {
                for (Employe employe : employes) {
                    if (employe.getStation().getRefRegion().equals(circuit.getRefChemin())) {
                        for (PlanificationProduction planificationProductionn : planificationProduction) {
                            if (employe.getMatricule().equals(planificationProductionn.getMatricule())) {
                                Long dimancheValue = planificationProductionn.getDimanche();
                                Long lundiValue = planificationProductionn.getLundi();
                                Long mardiValue = planificationProductionn.getMardi();
                                Long mercrediValue = planificationProductionn.getMercredi();
                                Long jeudiValue = planificationProductionn.getJeudi();
                                Long vendrediValue = planificationProductionn.getVendredi();
                                Long samediValue = planificationProductionn.getSamedi();
                                if (dimancheValue != null) {
                                    if (dimancheValue == 5301350 ) {

                                        PlanificationTransport planificationTransport = createPlanificationTransport("dimanche", 530, 1350, planfications,agence,circuit.getRefChemin());
                                        if(AllplanificationTransport.isEmpty()){
                                            planificationTransportRepository.save(planificationTransport);
                                        }  else{
                                            for( PlanificationTransport allplanificationTransport :AllplanificationTransport){



                                                if(allplanificationTransport.getAgence().equals(agence) ){
                                                    return null;
                                                }else{
                                                    System.out.println(allplanificationTransport.getAgence());
                                                    planificationTransportRepository.save(planificationTransport);

                                                }
                                            }
                                        }

                                    }
                                    if (dimancheValue == 13502215 ) {
                                        PlanificationTransport planificationTransport = createPlanificationTransport("dimanche", 1350, 2215, planfications,agence,circuit.getRefChemin());
                                        if(AllplanificationTransport.isEmpty()){
                                            planificationTransportRepository.save(planificationTransport);
                                        }  else{
                                            for( PlanificationTransport allplanificationTransport :AllplanificationTransport){



                                                if(allplanificationTransport.getAgence().equals(agence) ){
                                                    return null;
                                                }else{
                                                    System.out.println(allplanificationTransport.getAgence());
                                                    planificationTransportRepository.save(planificationTransport);

                                                }
                                            }
                                        }

                                    }
                                }
                                if (lundiValue != null) {
                                    if (lundiValue == 5301350 ) {
                                        PlanificationTransport planificationTransport = createPlanificationTransport("lundi", 530, 1350, planfications,agence,circuit.getRefChemin());
                                        if(AllplanificationTransport.isEmpty()){
                                            planificationTransportRepository.save(planificationTransport);
                                        }  else{
                                            for( PlanificationTransport allplanificationTransport :AllplanificationTransport){



                                                if(allplanificationTransport.getAgence().equals(agence) ){
                                                    return null;
                                                }else{
                                                    System.out.println(allplanificationTransport.getAgence());
                                                    planificationTransportRepository.save(planificationTransport);

                                                }
                                            }
                                        }
                                    }
                                    if (lundiValue == 13502215 ) {
                                        PlanificationTransport planificationTransport = createPlanificationTransport("lundi", 1350, 2215, planfications,agence,circuit.getRefChemin());
                                        if(AllplanificationTransport.isEmpty()){
                                            planificationTransportRepository.save(planificationTransport);
                                        }  else{
                                            for( PlanificationTransport allplanificationTransport :AllplanificationTransport){



                                                if(allplanificationTransport.getAgence().equals(agence) ){
                                                    return null;
                                                }else{
                                                    System.out.println(allplanificationTransport.getAgence());
                                                    planificationTransportRepository.save(planificationTransport);

                                                }
                                            }
                                        }
                                    }
                                }
                                if (mardiValue != null) {
                                    if (mardiValue == 5301350 ) {
                                        PlanificationTransport planificationTransport = createPlanificationTransport("mardi", 530, 1350, planfications,agence,circuit.getRefChemin());
                                        if(AllplanificationTransport.isEmpty()){
                                            planificationTransportRepository.save(planificationTransport);
                                        }  else{
                                            for( PlanificationTransport allplanificationTransport :AllplanificationTransport){



                                                if(allplanificationTransport.getAgence().equals(agence) ){
                                                    return null;
                                                }else{
                                                    System.out.println(allplanificationTransport.getAgence());
                                                    planificationTransportRepository.save(planificationTransport);

                                                }
                                            }
                                        }
                                    }
                                    if (mardiValue == 13502215 ) {
                                        PlanificationTransport planificationTransport = createPlanificationTransport("mardi", 1350, 2215, planfications,agence,circuit.getRefChemin());
                                        if(AllplanificationTransport.isEmpty()){
                                            planificationTransportRepository.save(planificationTransport);
                                        }  else{
                                            for( PlanificationTransport allplanificationTransport :AllplanificationTransport){



                                                if(allplanificationTransport.getAgence().equals(agence) ){
                                                    return null;
                                                }else{
                                                    System.out.println(allplanificationTransport.getAgence());
                                                    planificationTransportRepository.save(planificationTransport);

                                                }
                                            }
                                        }
                                    }
                                }
                                if (mercrediValue != null) {
                                    if (mercrediValue == 5301350 ) {
                                        PlanificationTransport planificationTransport = createPlanificationTransport("mercredi", 530, 1350, planfications,agence,circuit.getRefChemin());
                                        if(AllplanificationTransport.isEmpty()){
                                            planificationTransportRepository.save(planificationTransport);
                                        }  else{
                                            for( PlanificationTransport allplanificationTransport :AllplanificationTransport){



                                                if(allplanificationTransport.getAgence().equals(agence) ){
                                                    return null;
                                                }else{
                                                    System.out.println(allplanificationTransport.getAgence());
                                                    planificationTransportRepository.save(planificationTransport);

                                                }
                                            }
                                        }
                                    }
                                    if (mercrediValue == 13502215 ) {
                                        PlanificationTransport planificationTransport = createPlanificationTransport("mercredi", 1350, 2215, planfications,agence,circuit.getRefChemin());
                                        if(AllplanificationTransport.isEmpty()){
                                            planificationTransportRepository.save(planificationTransport);
                                        }  else{
                                            for( PlanificationTransport allplanificationTransport :AllplanificationTransport){



                                                if(allplanificationTransport.getAgence().equals(agence) ){
                                                    return null;
                                                }else{
                                                    System.out.println(allplanificationTransport.getAgence());
                                                    planificationTransportRepository.save(planificationTransport);

                                                }
                                            }
                                        }
                                    }
                                }
                                if (jeudiValue != null) {
                                    if (jeudiValue == 5301350 ) {
                                        PlanificationTransport planificationTransport = createPlanificationTransport("jeudi", 530, 1350, planfications,agence,circuit.getRefChemin());
                                        if(AllplanificationTransport.isEmpty()){
                                            planificationTransportRepository.save(planificationTransport);
                                        }  else{
                                            for( PlanificationTransport allplanificationTransport :AllplanificationTransport){



                                                if(allplanificationTransport.getAgence().equals(agence) ){
                                                    return null;
                                                }else{
                                                    System.out.println(allplanificationTransport.getAgence());
                                                    planificationTransportRepository.save(planificationTransport);

                                                }
                                            }
                                        }
                                    }
                                    if (jeudiValue == 13502215 ) {
                                        PlanificationTransport planificationTransport = createPlanificationTransport("jeudi", 1350, 2215, planfications,agence,circuit.getRefChemin());
                                        if(AllplanificationTransport.isEmpty()){
                                            planificationTransportRepository.save(planificationTransport);
                                        }  else{
                                            for( PlanificationTransport allplanificationTransport :AllplanificationTransport){



                                                if(allplanificationTransport.getAgence().equals(agence) ){
                                                    return null;
                                                }else{
                                                    System.out.println(allplanificationTransport.getAgence());
                                                    planificationTransportRepository.save(planificationTransport);

                                                }
                                            }
                                        }
                                    }
                                }
                                if (vendrediValue != null) {
                                    if (vendrediValue == 5301350 ) {
                                        PlanificationTransport planificationTransport = createPlanificationTransport("vendredi", 530, 1350, planfications,agence,circuit.getRefChemin());
                                        if(AllplanificationTransport.isEmpty()){
                                            planificationTransportRepository.save(planificationTransport);
                                        }  else{
                                            for( PlanificationTransport allplanificationTransport :AllplanificationTransport){



                                                if(allplanificationTransport.getAgence().equals(agence) ){
                                                    return null;
                                                }else{
                                                    System.out.println(allplanificationTransport.getAgence());
                                                    planificationTransportRepository.save(planificationTransport);

                                                }
                                            }
                                        }
                                    }

                                    if (vendrediValue == 13502215 ) {
                                        PlanificationTransport planificationTransport = createPlanificationTransport("vendredi", 1350, 2215, planfications,agence,circuit.getRefChemin());
                                        if(AllplanificationTransport.isEmpty()){
                                            planificationTransportRepository.save(planificationTransport);
                                        }  else{
                                            for( PlanificationTransport allplanificationTransport :AllplanificationTransport){



                                                if(allplanificationTransport.getAgence().equals(agence) ){
                                                    return null;
                                                }else{
                                                    System.out.println(allplanificationTransport.getAgence());
                                                    planificationTransportRepository.save(planificationTransport);

                                                }
                                            }
                                        }
                                    }
                                }
                                if (samediValue != null) {
                                    if (samediValue == 5301350 ) {
                                        PlanificationTransport planificationTransport = createPlanificationTransport("samedi", 530, 1350, planfications,agence,circuit.getRefChemin());
                                        if(AllplanificationTransport.isEmpty()){
                                            planificationTransportRepository.save(planificationTransport);
                                        }  else{
                                            for( PlanificationTransport allplanificationTransport :AllplanificationTransport){



                                                if(allplanificationTransport.getAgence().equals(agence) ){
                                                    return null;
                                                }else{
                                                    System.out.println(allplanificationTransport.getAgence());
                                                    planificationTransportRepository.save(planificationTransport);

                                                }
                                            }
                                        }
                                    }

                                    if (samediValue == 13502215 ) {
                                        PlanificationTransport planificationTransport = createPlanificationTransport("samedi", 1350, 2215, planfications,agence,circuit.getRefChemin());
                                        if(AllplanificationTransport.isEmpty()){
                                            planificationTransportRepository.save(planificationTransport);
                                        }  else{
                                            for( PlanificationTransport allplanificationTransport :AllplanificationTransport){



                                                if(allplanificationTransport.getAgence().equals(agence) ){
                                                    return null;
                                                }else{
                                                    System.out.println(allplanificationTransport.getAgence());
                                                    planificationTransportRepository.save(planificationTransport);

                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return planfications;
    }

    @Override
    public void deleteAllData() {
        planificationTransportRepository.deleteAll();
    }

    private PlanificationTransport createPlanificationTransport(String jourSemaine, int debutPoste, int finPoste, List<PlanificationTransport> planfications,String agence,String circuit) {
        PlanificationTransport planificationTransport = new PlanificationTransport();
        planificationTransport.setJourSemaine(jourSemaine);
        planificationTransport.setDebutPoste(debutPoste);
        planificationTransport.setFinPoste(finPoste);
        planificationTransport.setNombreEmploye(0);
        planificationTransport.setAgence(agence);
        planificationTransport.setCircuit(circuit);
        planfications.add(planificationTransport);
        return planificationTransport;
    }
}
