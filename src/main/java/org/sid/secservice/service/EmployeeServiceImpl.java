package org.sid.secservice.service;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.sid.secservice.entities.AppRole;
import org.sid.secservice.entities.Employe;
import org.sid.secservice.entities.PlantSection;
import org.sid.secservice.entities.Segment;
import org.sid.secservice.repo.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.io.IOException;

@Service
public class EmployeeServiceImpl  implements EmployeeService {
    private EmployeRepository employeeRepository;
    private PlantSectionService plantSectionService;
    private SegmentService segmentService;

    public EmployeeServiceImpl(PlantSectionService plantSectionService) {
        this.plantSectionService = plantSectionService;
    }

    public EmployeeServiceImpl(EmployeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeServiceImpl(SegmentService segmentService) {
        this.segmentService = segmentService;
    }
    @Autowired
    public EmployeeServiceImpl(EmployeRepository employeeRepository, PlantSectionService plantSectionService, SegmentService segmentService) {
        this.employeeRepository = employeeRepository;
        this.plantSectionService = plantSectionService;
        this.segmentService = segmentService;
    }




    public void importEmployeesFromExcel(MultipartFile file) throws IOException  {
        try (Workbook workbook = WorkbookFactory.create(file.getInputStream())) {
            Sheet sheet = workbook.getSheetAt(0); // Assuming the first sheet contains the employee data
            Iterator<Row> rowIterator = sheet.iterator();

            List<Employe> employees = new ArrayList<>();

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();

                // Assuming the data is present in the first three columns (you can adjust this based on your Excel format)
                Cell nom = row.getCell(0);
                Cell prenom = row.getCell(1);
               Cell contreMetre = row.getCell(2);
              //  Cell NomGroupe = row.getCell(3);
                Cell PS = row.getCell(3);
                Cell nomGroupe = row.getCell(4);
                Cell centreCout = row.getCell(5);
                Cell telephone = row.getCell(6);
                Cell matricule = row.getCell(7);
                Cell segment = row.getCell(8);

                if (nom != null && prenom != null && contreMetre!=null && PS!=null&& nomGroupe!=null
                        && centreCout!=null && telephone!=null && matricule!=null && segment!=null) {

                    String NomEmploye = nom.getStringCellValue();
                    String PrenomEmploye = prenom.getStringCellValue();
                    String ContreMetreEmploye = contreMetre.getStringCellValue();
                   String NomGroupeEmployeString = nomGroupe.getStringCellValue();
                    String PSEmployeString = PS.getStringCellValue();
                    double centreCoutEmployeString = centreCout.getNumericCellValue();
                    long  centreCoutEmploye = (long)centreCoutEmployeString;
                    double telephoneEmployeString = telephone.getNumericCellValue();
                    long  telephoneEmploye = (long)telephoneEmployeString;
                    double matriculeEmployeString = matricule.getNumericCellValue();
                    long  matriculeEmploye = (long)matriculeEmployeString;
                    String segmentEmployeString = segment.getStringCellValue();
                 //   String email = emailCell.getStringCellValue();
                    PlantSection psEmploye = this.plantSectionService.findPlantSectionBynomPs(PSEmployeString);
                    Segment segmentEmploye = this.segmentService.findSegmentBynomSegment(segmentEmployeString);
                    // You can perform additional validation and data cleaning here if needed
                    System.out.println(psEmploye);
                    System.out.println(segmentEmploye);
                    Employe employee = new Employe(null,matriculeEmploye,NomEmploye,PrenomEmploye,ContreMetreEmploye,NomGroupeEmployeString,telephoneEmploye,centreCoutEmploye,psEmploye,segmentEmploye);

                    employee.setPs(psEmploye);
                    employee.setSegment(segmentEmploye);
                    System.out.println(employee);
                    employees.add(employee);
                }
            }

            // Save the employees to the database using the employeeRepository
            employeeRepository.saveAll(employees);
        }
    }

    @Override
    public List<Employe> listEmployes() {
        return employeeRepository.findAll();
    }

    @Override
    public Employe updateEmploye(Employe employe) {
        return (Employe) employeeRepository.save(employe);
    }
}

