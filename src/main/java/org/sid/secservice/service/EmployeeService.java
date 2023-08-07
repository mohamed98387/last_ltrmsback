package org.sid.secservice.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface EmployeeService {
    public void importEmployeesFromExcel(MultipartFile file)throws IOException;
}
