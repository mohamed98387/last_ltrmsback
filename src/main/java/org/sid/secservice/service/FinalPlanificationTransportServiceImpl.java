package org.sid.secservice.service;

import org.sid.secservice.entities.Circuit;
import org.sid.secservice.entities.FinalPlanificationTransport;
import org.sid.secservice.entities.PlanificationTransport;
import org.sid.secservice.entities.Station;
import org.sid.secservice.repo.FinalPlanificationTransportRepository;
import org.sid.secservice.repo.PlanificationTransportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FinalPlanificationTransportServiceImpl implements FinalPlanificationTransportService  {
    private PlanificationTransportRepository planificationTransportRepository;
    private FinalPlanificationTransportRepository finalPlanificationTransportRepository;




    public FinalPlanificationTransportServiceImpl(FinalPlanificationTransportRepository finalPlanificationTransportRepository) {
        this.finalPlanificationTransportRepository = finalPlanificationTransportRepository;
    }

    public FinalPlanificationTransportServiceImpl(PlanificationTransportRepository planificationTransportRepository) {
        this.planificationTransportRepository = planificationTransportRepository;
    }
    @Autowired
    public FinalPlanificationTransportServiceImpl(PlanificationTransportRepository planificationTransportRepository, FinalPlanificationTransportRepository finalPlanificationTransportRepository) {
        this.planificationTransportRepository = planificationTransportRepository;
        this.finalPlanificationTransportRepository = finalPlanificationTransportRepository;
    }


    @Override
    public List<FinalPlanificationTransport> lisFinalPlanificationTransports() {
        return finalPlanificationTransportRepository.findAll();
    }

    @Override
    public List<FinalPlanificationTransport> newlPlanificationTransport(String agence) {
        int totalEmployees = 0;
        boolean existingObjectFound = false;
        boolean x = false;
        List<PlanificationTransport> planfications = this.planificationTransportRepository.findAll();
        List<FinalPlanificationTransport> finalPlanificationTransports = this.finalPlanificationTransportRepository.findAll();
        for (FinalPlanificationTransport finalplanificationTransport : finalPlanificationTransports) {
            if(finalplanificationTransport.getAgence().equals(agence)){
                x=true;
            }
        }
        for (PlanificationTransport planificationTransport : planfications) {
            if (planificationTransport.getJourSemaine().equals("samedi") &&
                    planificationTransport.getDebutPoste() == 530 && planificationTransport.getAgence().equals(agence)
                    && x==false
            ) {
                FinalPlanificationTransport existingRecord = finalPlanificationTransportRepository.findFinalPlanificationTransportByjourSemaineAndDebutPosteAndAgence("samedi", 530,agence);

                if (existingRecord == null) {
                    FinalPlanificationTransport finalPlanificationTransport = new FinalPlanificationTransport();
                    finalPlanificationTransport.setJourSemaine("samedi");
                    finalPlanificationTransport.setDebutPoste(530);
                    finalPlanificationTransport.setFinPoste(1350);
                    finalPlanificationTransport.setNombreEmploye(planificationTransport.getNombreEmploye() + 1);
                    finalPlanificationTransport.setAgence(planificationTransport.getAgence());
                    finalPlanificationTransport.setCircuit(planificationTransport.getCircuit());
                    finalPlanificationTransportRepository.save(finalPlanificationTransport);
                } else {
                    existingRecord.setNombreEmploye(existingRecord.getNombreEmploye() + 1);
                    if (existingRecord.getNombreEmploye() % 2 == 0) {
                        // Increment the numberbus property when the number of employees is a multiple of 2.
                        existingRecord.setNombresBus(existingRecord.getNombresBus() + 1);
                    }

                    finalPlanificationTransportRepository.save(existingRecord);
                }
            }
            /////////////////////////////////////////////////////////////
            if (planificationTransport.getJourSemaine().equals("samedi") &&
                    planificationTransport.getDebutPoste() == 1350 && planificationTransport.getAgence().equals(agence)
                    && x==false) {
                FinalPlanificationTransport existingRecord = finalPlanificationTransportRepository.findFinalPlanificationTransportByjourSemaineAndDebutPosteAndAgence("samedi", 1350,agence);

                if (existingRecord == null ) {
                    FinalPlanificationTransport finalPlanificationTransport = new FinalPlanificationTransport();
                    finalPlanificationTransport.setJourSemaine("samedi");
                    finalPlanificationTransport.setDebutPoste(1350);
                    finalPlanificationTransport.setFinPoste(2250);
                    finalPlanificationTransport.setNombreEmploye(planificationTransport.getNombreEmploye() + 1);
                    finalPlanificationTransport.setAgence(planificationTransport.getAgence());
                    finalPlanificationTransport.setCircuit(planificationTransport.getCircuit());
                    finalPlanificationTransportRepository.save(finalPlanificationTransport);
                } else {
                    existingRecord.setNombreEmploye(existingRecord.getNombreEmploye() + 1);
                    if (existingRecord.getNombreEmploye() % 2 == 0) {
                        // Increment the numberbus property when the number of employees is a multiple of 2.
                        existingRecord.setNombresBus(existingRecord.getNombresBus() + 1);
                    }
                    finalPlanificationTransportRepository.save(existingRecord);
                }
            }
            /////////////////////////////////////////////////////////////
            if (planificationTransport.getJourSemaine().equals("vendredi") &&
                    planificationTransport.getDebutPoste() == 530 && planificationTransport.getAgence().equals(agence)
                    && x==false) {
                FinalPlanificationTransport existingRecord = finalPlanificationTransportRepository.findFinalPlanificationTransportByjourSemaineAndDebutPosteAndAgence("vendredi", 530,agence);

                if (existingRecord == null) {
                    FinalPlanificationTransport finalPlanificationTransport = new FinalPlanificationTransport();
                    finalPlanificationTransport.setJourSemaine("vendredi");
                    finalPlanificationTransport.setDebutPoste(530);
                    finalPlanificationTransport.setFinPoste(1350);
                    finalPlanificationTransport.setNombreEmploye(planificationTransport.getNombreEmploye() + 1);
                    finalPlanificationTransport.setAgence(planificationTransport.getAgence());
                    finalPlanificationTransport.setCircuit(planificationTransport.getCircuit());
                    finalPlanificationTransportRepository.save(finalPlanificationTransport);
                } else {
                    existingRecord.setNombreEmploye(existingRecord.getNombreEmploye() + 1);
                    if (existingRecord.getNombreEmploye() % 2 == 0) {
                        // Increment the numberbus property when the number of employees is a multiple of 2.
                        existingRecord.setNombresBus(existingRecord.getNombresBus() + 1);
                    }
                    finalPlanificationTransportRepository.save(existingRecord);
                }
            }
            /////////////////////////////////////////////////////////////
            if (planificationTransport.getJourSemaine().equals("vendredi") &&
                    planificationTransport.getDebutPoste() == 1350
                    && planificationTransport.getAgence().equals(agence)&& x==false) {
                FinalPlanificationTransport existingRecord = finalPlanificationTransportRepository.findFinalPlanificationTransportByjourSemaineAndDebutPosteAndAgence("vendredi", 1350,agence);

                if (existingRecord == null) {
                    FinalPlanificationTransport finalPlanificationTransport = new FinalPlanificationTransport();
                    finalPlanificationTransport.setJourSemaine("vendredi");
                    finalPlanificationTransport.setDebutPoste(1350);
                    finalPlanificationTransport.setFinPoste(2250);
                    finalPlanificationTransport.setNombreEmploye(planificationTransport.getNombreEmploye() + 1);
                    finalPlanificationTransport.setAgence(planificationTransport.getAgence());
                    finalPlanificationTransport.setCircuit(planificationTransport.getCircuit());
                    finalPlanificationTransportRepository.save(finalPlanificationTransport);
                } else {
                    existingRecord.setNombreEmploye(existingRecord.getNombreEmploye() + 1);
                    if (existingRecord.getNombreEmploye() % 2 == 0) {
                        // Increment the numberbus property when the number of employees is a multiple of 2.
                        existingRecord.setNombresBus(existingRecord.getNombresBus() + 1);
                    }
                    finalPlanificationTransportRepository.save(existingRecord);
                }
            }
            /////////////////////////////////////////////////////////////
            if (planificationTransport.getJourSemaine().equals("jeudi") &&
                    planificationTransport.getDebutPoste() == 530
                    && planificationTransport.getAgence().equals(agence)&& x==false) {
                FinalPlanificationTransport existingRecord = finalPlanificationTransportRepository.findFinalPlanificationTransportByjourSemaineAndDebutPosteAndAgence("jeudi", 530,agence);

                if (existingRecord == null) {
                    FinalPlanificationTransport finalPlanificationTransport = new FinalPlanificationTransport();
                    finalPlanificationTransport.setJourSemaine("jeudi");
                    finalPlanificationTransport.setDebutPoste(530);
                    finalPlanificationTransport.setFinPoste(1350);
                    finalPlanificationTransport.setNombreEmploye(planificationTransport.getNombreEmploye() + 1);
                    finalPlanificationTransport.setAgence(planificationTransport.getAgence());
                    finalPlanificationTransport.setCircuit(planificationTransport.getCircuit());
                    finalPlanificationTransportRepository.save(finalPlanificationTransport);
                } else {
                    existingRecord.setNombreEmploye(existingRecord.getNombreEmploye() + 1);
                    if (existingRecord.getNombreEmploye() % 2 == 0) {
                        // Increment the numberbus property when the number of employees is a multiple of 2.
                        existingRecord.setNombresBus(existingRecord.getNombresBus() + 1);
                    }
                    finalPlanificationTransportRepository.save(existingRecord);
                }
            }
            /////////////////////////////////////////////////////////////
            if (planificationTransport.getJourSemaine().equals("jeudi") &&
                    planificationTransport.getDebutPoste() == 1350
                    && planificationTransport.getAgence().equals(agence)&& x==false) {
                FinalPlanificationTransport existingRecord = finalPlanificationTransportRepository.findFinalPlanificationTransportByjourSemaineAndDebutPosteAndAgence("jeudi", 1350,agence);

                if (existingRecord == null) {
                    FinalPlanificationTransport finalPlanificationTransport = new FinalPlanificationTransport();
                    finalPlanificationTransport.setJourSemaine("jeudi");
                    finalPlanificationTransport.setDebutPoste(1350);
                    finalPlanificationTransport.setFinPoste(2250);
                    finalPlanificationTransport.setNombreEmploye(planificationTransport.getNombreEmploye() + 1);
                    finalPlanificationTransport.setAgence(planificationTransport.getAgence());
                    finalPlanificationTransport.setCircuit(planificationTransport.getCircuit());
                    finalPlanificationTransportRepository.save(finalPlanificationTransport);
                } else {
                    existingRecord.setNombreEmploye(existingRecord.getNombreEmploye() + 1);
                    if (existingRecord.getNombreEmploye() % 2 == 0) {
                        // Increment the numberbus property when the number of employees is a multiple of 2.
                        existingRecord.setNombresBus(existingRecord.getNombresBus() + 1);
                    }
                    finalPlanificationTransportRepository.save(existingRecord);
                }
            }
            /////////////////////////////////////////////////////////////
            if (planificationTransport.getJourSemaine().equals("mercredi") &&
                    planificationTransport.getDebutPoste() == 530
                    && planificationTransport.getAgence().equals(agence)&& x==false) {
                FinalPlanificationTransport existingRecord = finalPlanificationTransportRepository.findFinalPlanificationTransportByjourSemaineAndDebutPosteAndAgence("mercredi", 530,agence);

                if (existingRecord == null) {
                    FinalPlanificationTransport finalPlanificationTransport = new FinalPlanificationTransport();
                    finalPlanificationTransport.setJourSemaine("mercredi");
                    finalPlanificationTransport.setDebutPoste(530);
                    finalPlanificationTransport.setFinPoste(1350);
                    finalPlanificationTransport.setNombreEmploye(planificationTransport.getNombreEmploye() + 1);
                    finalPlanificationTransport.setAgence(planificationTransport.getAgence());
                    finalPlanificationTransport.setCircuit(planificationTransport.getCircuit());
                    finalPlanificationTransportRepository.save(finalPlanificationTransport);
                } else {
                    existingRecord.setNombreEmploye(existingRecord.getNombreEmploye() + 1);
                    if (existingRecord.getNombreEmploye() % 2 == 0) {
                        // Increment the numberbus property when the number of employees is a multiple of 2.
                        existingRecord.setNombresBus(existingRecord.getNombresBus() + 1);
                    }
                    finalPlanificationTransportRepository.save(existingRecord);
                }
            }
            /////////////////////////////////////////////////////////////
            if (planificationTransport.getJourSemaine().equals("mercredi") &&
                    planificationTransport.getDebutPoste() == 1350 && planificationTransport.getAgence().equals(agence)
                    && x==false) {
                FinalPlanificationTransport existingRecord = finalPlanificationTransportRepository.findFinalPlanificationTransportByjourSemaineAndDebutPosteAndAgence("mercredi", 1350,agence);

                if (existingRecord == null) {
                    FinalPlanificationTransport finalPlanificationTransport = new FinalPlanificationTransport();
                    finalPlanificationTransport.setJourSemaine("mercredi");
                    finalPlanificationTransport.setDebutPoste(1350);
                    finalPlanificationTransport.setFinPoste(2250);
                    finalPlanificationTransport.setNombreEmploye(planificationTransport.getNombreEmploye() + 1);
                    finalPlanificationTransport.setAgence(planificationTransport.getAgence());
                    finalPlanificationTransport.setCircuit(planificationTransport.getCircuit());
                    finalPlanificationTransportRepository.save(finalPlanificationTransport);
                } else {
                    existingRecord.setNombreEmploye(existingRecord.getNombreEmploye() + 1);
                    if (existingRecord.getNombreEmploye() % 2 == 0) {
                        // Increment the numberbus property when the number of employees is a multiple of 2.
                        existingRecord.setNombresBus(existingRecord.getNombresBus() + 1);
                    }
                    finalPlanificationTransportRepository.save(existingRecord);
                }
            }
            /////////////////////////////////////////////////////////////
            if (planificationTransport.getJourSemaine().equals("mardi") &&
                    planificationTransport.getDebutPoste() == 530 && planificationTransport.getAgence().equals(agence)
                    && x==false) {
                FinalPlanificationTransport existingRecord = finalPlanificationTransportRepository.findFinalPlanificationTransportByjourSemaineAndDebutPosteAndAgence("mardi", 530,agence);

                if (existingRecord == null) {
                    FinalPlanificationTransport finalPlanificationTransport = new FinalPlanificationTransport();
                    finalPlanificationTransport.setJourSemaine("mardi");
                    finalPlanificationTransport.setDebutPoste(530);
                    finalPlanificationTransport.setFinPoste(1350);
                    finalPlanificationTransport.setNombreEmploye(planificationTransport.getNombreEmploye() + 1);
                    finalPlanificationTransport.setAgence(planificationTransport.getAgence());
                    finalPlanificationTransport.setCircuit(planificationTransport.getCircuit());
                    finalPlanificationTransportRepository.save(finalPlanificationTransport);
                } else {
                    existingRecord.setNombreEmploye(existingRecord.getNombreEmploye() + 1);
                    if (existingRecord.getNombreEmploye() % 2 == 0) {
                        // Increment the numberbus property when the number of employees is a multiple of 2.
                        existingRecord.setNombresBus(existingRecord.getNombresBus() + 1);
                    }
                    finalPlanificationTransportRepository.save(existingRecord);
                }
            }
            /////////////////////////////////////////////////////////////
            if (planificationTransport.getJourSemaine().equals("mardi") &&
                    planificationTransport.getDebutPoste() == 1350 && planificationTransport.getAgence().equals(agence)
                    && x==false) {
                FinalPlanificationTransport existingRecord = finalPlanificationTransportRepository.findFinalPlanificationTransportByjourSemaineAndDebutPosteAndAgence("mardi", 1350,agence);

                if (existingRecord == null) {
                    FinalPlanificationTransport finalPlanificationTransport = new FinalPlanificationTransport();
                    finalPlanificationTransport.setJourSemaine("mardi");
                    finalPlanificationTransport.setDebutPoste(1350);
                    finalPlanificationTransport.setFinPoste(2250);
                    finalPlanificationTransport.setNombreEmploye(planificationTransport.getNombreEmploye() + 1);
                    finalPlanificationTransport.setAgence(planificationTransport.getAgence());
                    finalPlanificationTransport.setCircuit(planificationTransport.getCircuit());
                    finalPlanificationTransportRepository.save(finalPlanificationTransport);
                } else {
                    existingRecord.setNombreEmploye(existingRecord.getNombreEmploye() + 1);
                    if (existingRecord.getNombreEmploye() % 2 == 0) {
                        // Increment the numberbus property when the number of employees is a multiple of 2.
                        existingRecord.setNombresBus(existingRecord.getNombresBus() + 1);
                    }
                    finalPlanificationTransportRepository.save(existingRecord);
                }
            }
            /////////////////////////////////////////////////////////////
            if (planificationTransport.getJourSemaine().equals("lundi") &&
                    planificationTransport.getDebutPoste() == 530
                    && planificationTransport.getAgence().equals(agence)
                    && x==false) {
                FinalPlanificationTransport existingRecord = finalPlanificationTransportRepository.findFinalPlanificationTransportByjourSemaineAndDebutPosteAndAgence("lundi", 530,agence);

                if (existingRecord == null) {
                    FinalPlanificationTransport finalPlanificationTransport = new FinalPlanificationTransport();
                    finalPlanificationTransport.setJourSemaine("lundi");
                    finalPlanificationTransport.setDebutPoste(530);
                    finalPlanificationTransport.setFinPoste(1350);
                    finalPlanificationTransport.setNombreEmploye(planificationTransport.getNombreEmploye() + 1);
                    finalPlanificationTransport.setAgence(planificationTransport.getAgence());
                    finalPlanificationTransport.setCircuit(planificationTransport.getCircuit());
                    finalPlanificationTransportRepository.save(finalPlanificationTransport);
                } else {
                    existingRecord.setNombreEmploye(existingRecord.getNombreEmploye() + 1);
                    if (existingRecord.getNombreEmploye() % 2 == 0) {
                        // Increment the numberbus property when the number of employees is a multiple of 2.
                        existingRecord.setNombresBus(existingRecord.getNombresBus() + 1);
                    }
                    finalPlanificationTransportRepository.save(existingRecord);
                }
            }      /////////////////////////////////////////////////////////////
            if (planificationTransport.getJourSemaine().equals("lundi") &&
                    planificationTransport.getDebutPoste() == 1350
                    && planificationTransport.getAgence().equals(agence)
                    && x==false) {
                FinalPlanificationTransport existingRecord = finalPlanificationTransportRepository.findFinalPlanificationTransportByjourSemaineAndDebutPosteAndAgence("lundi", 1350,agence);

                if (existingRecord == null) {
                    FinalPlanificationTransport finalPlanificationTransport = new FinalPlanificationTransport();
                    finalPlanificationTransport.setJourSemaine("lundi");
                    finalPlanificationTransport.setDebutPoste(1350);
                    finalPlanificationTransport.setFinPoste(2250);
                    finalPlanificationTransport.setNombreEmploye(planificationTransport.getNombreEmploye() + 1);
                    finalPlanificationTransport.setAgence(planificationTransport.getAgence());
                    finalPlanificationTransport.setCircuit(planificationTransport.getCircuit());
                    finalPlanificationTransportRepository.save(finalPlanificationTransport);
                } else {
                    existingRecord.setNombreEmploye(existingRecord.getNombreEmploye() + 1);
                    if (existingRecord.getNombreEmploye() % 2 == 0) {
                        // Increment the numberbus property when the number of employees is a multiple of 2.
                        existingRecord.setNombresBus(existingRecord.getNombresBus() + 1);
                    }
                    finalPlanificationTransportRepository.save(existingRecord);
                }
            }
            /////////////////////////////////////////////////////////////
            if (planificationTransport.getJourSemaine().equals("dimanche") &&
                    planificationTransport.getDebutPoste() == 530
                    && planificationTransport.getAgence().equals(agence)
                    && x==false) {
                FinalPlanificationTransport existingRecord = finalPlanificationTransportRepository.findFinalPlanificationTransportByjourSemaineAndDebutPosteAndAgence("dimanche", 530,agence);

                if (existingRecord == null) {
                    FinalPlanificationTransport finalPlanificationTransport = new FinalPlanificationTransport();
                    finalPlanificationTransport.setJourSemaine("dimanche");
                    finalPlanificationTransport.setDebutPoste(530);
                    finalPlanificationTransport.setFinPoste(1350);
                    finalPlanificationTransport.setNombreEmploye(planificationTransport.getNombreEmploye() + 1);
                    finalPlanificationTransport.setAgence(planificationTransport.getAgence());
                    finalPlanificationTransport.setCircuit(planificationTransport.getCircuit());
                    finalPlanificationTransportRepository.save(finalPlanificationTransport);
                } else {
                    existingRecord.setNombreEmploye(existingRecord.getNombreEmploye() + 1);
                    if (existingRecord.getNombreEmploye() % 2 == 0) {
                        // Increment the numberbus property when the number of employees is a multiple of 2.
                        existingRecord.setNombresBus(existingRecord.getNombresBus() + 1);
                    }
                    finalPlanificationTransportRepository.save(existingRecord);
                }
            }
            /////////////////////////////////////////////////////////////
            if (planificationTransport.getJourSemaine().equals("dimanche") &&
                    planificationTransport.getDebutPoste() == 1350
                    && planificationTransport.getAgence().equals(agence)
                    && x==false) {
                FinalPlanificationTransport existingRecord = finalPlanificationTransportRepository.findFinalPlanificationTransportByjourSemaineAndDebutPosteAndAgence("dimanche", 1350,agence);

                if (existingRecord == null) {
                    FinalPlanificationTransport finalPlanificationTransport = new FinalPlanificationTransport();
                    finalPlanificationTransport.setJourSemaine("dimanche");
                    finalPlanificationTransport.setDebutPoste(1350);
                    finalPlanificationTransport.setFinPoste(2250);
                    finalPlanificationTransport.setNombreEmploye(planificationTransport.getNombreEmploye() + 1);
                    finalPlanificationTransport.setAgence(planificationTransport.getAgence());
                    finalPlanificationTransport.setCircuit(planificationTransport.getCircuit());
                    finalPlanificationTransportRepository.save(finalPlanificationTransport);
                } else {
                    existingRecord.setNombreEmploye(existingRecord.getNombreEmploye() + 1);
                    if (existingRecord.getNombreEmploye() % 2 == 0) {
                        // Increment the numberbus property when the number of employees is a multiple of 2.
                        existingRecord.setNombresBus(existingRecord.getNombresBus() + 1);
                    }
                    finalPlanificationTransportRepository.save(existingRecord);
                }
            }



        }

        return null;
    }

    @Override
    public FinalPlanificationTransport findFinalPlanificationTransportByid(Long id) {
        return finalPlanificationTransportRepository.findFinalPlanificationTransportByid(id);
    }

    @Override
    public FinalPlanificationTransport findFinalPlanificationTransportByjourSemaine(String jourSemaine) {
        return finalPlanificationTransportRepository.findFinalPlanificationTransportByjourSemaine(jourSemaine);
    }

    @Override
    public void deleteAllData() {
        finalPlanificationTransportRepository.deleteAll();
    }

}
