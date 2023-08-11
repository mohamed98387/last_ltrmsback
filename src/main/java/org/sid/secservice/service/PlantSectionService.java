package org.sid.secservice.service;

import org.sid.secservice.entities.Permission;
import org.sid.secservice.entities.PlantSection;

import java.util.List;

public interface PlantSectionService {
    PlantSection addNewPlantSection(PlantSection plantSection);
    List<PlantSection> listPlantSection();
    public PlantSection updatePlantSection(PlantSection plantSection);
    public void removePlantSection(Long id);
}
