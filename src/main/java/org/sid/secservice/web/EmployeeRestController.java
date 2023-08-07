package org.sid.secservice.web;

import org.sid.secservice.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class EmployeeRestController {
    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @PostMapping("/import-employees")
    public ResponseEntity<String> importEmployees(@RequestParam("my_file_1691416170827") MultipartFile file) {
        try {
            employeeService.importEmployeesFromExcel(file);
            return ResponseEntity.ok("Employees imported successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error importing employees: " + e.getMessage());
        }
    }
}
