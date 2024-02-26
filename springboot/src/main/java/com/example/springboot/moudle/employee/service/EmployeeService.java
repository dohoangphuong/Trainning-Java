package com.example.springboot.moudle.employee.service;

import com.example.springboot.moudle.employee.model.EmployeeDTO;
import com.example.springboot.moudle.employee.model.StudentDTO;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public abstract class EmployeeService {
    public abstract List<EmployeeDTO> getAll();

    public abstract StudentDTO searchSinhVien(long id);

    public abstract List<StudentDTO> findSinhVien();
}
