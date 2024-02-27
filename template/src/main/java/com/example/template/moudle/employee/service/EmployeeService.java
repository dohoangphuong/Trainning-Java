package com.example.template.moudle.employee.service;

import com.example.template.moudle.employee.model.EmployeeDTO;
import com.example.template.moudle.employee.model.StudentDTO;
import com.example.template.moudle.employee.model.StudentRequest;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public abstract class EmployeeService {
    public abstract List<EmployeeDTO> getAll();

    public abstract StudentDTO searchSinhVien(long id);

    public abstract List<StudentDTO> searchSinhVienByKhoaId(long id);

    public abstract List<StudentDTO> findSinhVien();

    public abstract List<StudentDTO> searchSinhVienBySinhVien(StudentRequest student);
}
