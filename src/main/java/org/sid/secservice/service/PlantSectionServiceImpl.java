package org.sid.secservice.service;

import org.sid.secservice.entities.Permission;
import org.sid.secservice.entities.PlantSection;
import org.sid.secservice.repo.PermissionRepository;
import org.sid.secservice.repo.PlantSectionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PlantSectionServiceImpl implements PlantSectionService {
    private PlantSectionRepository plantSectionRepository;

    public PlantSectionServiceImpl(PlantSectionRepository plantSectionRepository) {
        this.plantSectionRepository = plantSectionRepository;
    }

    @Override
    public PlantSection addNewPlantSection(PlantSection plantSection) {
        return this.plantSectionRepository.save(plantSection);
    }

    @Override
    public List<PlantSection> listPlantSection() {
        return plantSectionRepository.findAll();
    }

    @Override
    public PlantSection updatePlantSection(PlantSection plantSection) {
        return (PlantSection) plantSectionRepository.save(plantSection);
    }

    @Override
    public void removePlantSection(Long id) {
        plantSectionRepository.deleteById(id);
    }

    @Override
    public PlantSection findPlantSectionBynomPs(String nomPs) {
        return plantSectionRepository.findPlantSectionBynomPs(nomPs);
    }
}
