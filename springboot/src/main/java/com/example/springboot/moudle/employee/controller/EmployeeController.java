package com.example.springboot.moudle.employee.controller;

import com.example.springboot.moudle.employee.model.EmployeeDTO;
import com.example.springboot.moudle.employee.model.StudentDTO;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public abstract class EmployeeController {

    public abstract List<EmployeeDTO> getAll();

    public abstract StudentDTO searchSinhVien(long id);

    public abstract List<StudentDTO> findSinhVien();
}
