package org.sid.secservice.service;

import org.sid.secservice.entities.AppRole;
import org.sid.secservice.entities.Employe;
import org.sid.secservice.entities.PlantSection;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface EmployeeService {
    public void importEmployeesFromExcel(MultipartFile file)throws IOException;
    List<Employe> listEmployes();
    public Employe updateEmploye(Employe employe);
}
