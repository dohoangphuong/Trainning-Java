package com.example.springboot.moudle.employee.controller.Impl;

import com.example.springboot.moudle.employee.controller.EmployeeController;
import com.example.springboot.moudle.employee.model.EmployeeDTO;
import com.example.springboot.moudle.employee.model.StudentDTO;
import com.example.springboot.moudle.employee.service.EmployeeService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
public class EmployeeControllerImpl extends EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    public List<EmployeeDTO> getAll() {
        return employeeService.getAll();
    }

    public StudentDTO searchSinhVien(long id) {

        return employeeService.searchSinhVien(id);
    }

    public List<StudentDTO> findSinhVien() {

        return employeeService.findSinhVien();
    }
}
