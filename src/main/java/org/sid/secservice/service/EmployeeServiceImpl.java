package org.sid.secservice.service;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.sid.secservice.entities.Employe;
import org.sid.secservice.repo.EmployeRepository;
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

    public EmployeeServiceImpl(EmployeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    public void importEmployeesFromExcel(MultipartFile file) throws IOException  {
        try (Workbook workbook = WorkbookFactory.create(file.getInputStream())) {
            Sheet sheet = workbook.getSheetAt(0); // Assuming the first sheet contains the employee data
            Iterator<Row> rowIterator = sheet.iterator();

            List<Employe> employees = new ArrayList<>();

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                // Assuming the data is present in the first three columns (you can adjust this based on your Excel format)
                Cell Nom = row.getCell(0);
                Cell Prenom = row.getCell(1);
          //      Cell emailCell = row.getCell(2);

                if (Nom != null && Prenom != null ) {
                    System.out.println(Nom);
                    System.out.println(Prenom);
                    String NomEmploye = Nom.getStringCellValue();
                    String PrenomEmploye = Prenom.getStringCellValue();
                 //   String email = emailCell.getStringCellValue();

                    // You can perform additional validation and data cleaning here if needed
                    Employe employee = new Employe(null, null, NomEmploye,PrenomEmploye,null,null,null,null,null);
                    employees.add(employee);
                }
            }

            // Save the employees to the database using the employeeRepository
            employeeRepository.saveAll(employees);
        }
    }
    }

