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
    public List<FinalPlanificationTransport> newlPlanificationTransport() {
        int totalEmployees = 0;
        boolean existingObjectFound = false;
        List<PlanificationTransport> planfications = this.planificationTransportRepository.findAll();

        for (PlanificationTransport planificationTransport : planfications) {
            if (planificationTransport.getJourSemaine().equals("samedi") &&
                    planificationTransport.getDebutPoste() == 530) {
                FinalPlanificationTransport existingRecord = finalPlanificationTransportRepository.findFinalPlanificationTransportByjourSemaineAndDebutPoste("samedi", 530);

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
                    planificationTransport.getDebutPoste() == 1350) {
                FinalPlanificationTransport existingRecord = finalPlanificationTransportRepository.findFinalPlanificationTransportByjourSemaineAndDebutPoste("samedi", 1350);

                if (existingRecord == null) {
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
                    planificationTransport.getDebutPoste() == 530) {
                FinalPlanificationTransport existingRecord = finalPlanificationTransportRepository.findFinalPlanificationTransportByjourSemaineAndDebutPoste("vendredi", 530);

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
                    planificationTransport.getDebutPoste() == 1350) {
                FinalPlanificationTransport existingRecord = finalPlanificationTransportRepository.findFinalPlanificationTransportByjourSemaineAndDebutPoste("vendredi", 1350);

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
                    planificationTransport.getDebutPoste() == 530) {
                FinalPlanificationTransport existingRecord = finalPlanificationTransportRepository.findFinalPlanificationTransportByjourSemaineAndDebutPoste("jeudi", 530);

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
                    planificationTransport.getDebutPoste() == 1350) {
                FinalPlanificationTransport existingRecord = finalPlanificationTransportRepository.findFinalPlanificationTransportByjourSemaineAndDebutPoste("jeudi", 1350);

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
                    planificationTransport.getDebutPoste() == 530) {
                FinalPlanificationTransport existingRecord = finalPlanificationTransportRepository.findFinalPlanificationTransportByjourSemaineAndDebutPoste("mercredi", 530);

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
                    planificationTransport.getDebutPoste() == 1350) {
                FinalPlanificationTransport existingRecord = finalPlanificationTransportRepository.findFinalPlanificationTransportByjourSemaineAndDebutPoste("mercredi", 1350);

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
                    planificationTransport.getDebutPoste() == 530) {
                FinalPlanificationTransport existingRecord = finalPlanificationTransportRepository.findFinalPlanificationTransportByjourSemaineAndDebutPoste("mardi", 530);

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
                    planificationTransport.getDebutPoste() == 1350) {
                FinalPlanificationTransport existingRecord = finalPlanificationTransportRepository.findFinalPlanificationTransportByjourSemaineAndDebutPoste("mardi", 1350);

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
                    planificationTransport.getDebutPoste() == 530) {
                FinalPlanificationTransport existingRecord = finalPlanificationTransportRepository.findFinalPlanificationTransportByjourSemaineAndDebutPoste("lundi", 530);

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
                    planificationTransport.getDebutPoste() == 1350) {
                FinalPlanificationTransport existingRecord = finalPlanificationTransportRepository.findFinalPlanificationTransportByjourSemaineAndDebutPoste("lundi", 1350);

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
                    planificationTransport.getDebutPoste() == 530) {
                FinalPlanificationTransport existingRecord = finalPlanificationTransportRepository.findFinalPlanificationTransportByjourSemaineAndDebutPoste("dimanche", 530);

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
                    planificationTransport.getDebutPoste() == 1350) {
                FinalPlanificationTransport existingRecord = finalPlanificationTransportRepository.findFinalPlanificationTransportByjourSemaineAndDebutPoste("dimanche", 1350);

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
}
