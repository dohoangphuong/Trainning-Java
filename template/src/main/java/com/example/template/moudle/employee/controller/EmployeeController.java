package com.example.template.moudle.employee.controller;

import com.example.template.moudle.employee.model.EmployeeDTO;
import com.example.template.moudle.employee.model.StudentDTO;
import java.util.List;

import com.example.template.moudle.employee.model.StudentRequest;
import org.springframework.web.bind.annotation.RestController;

@RestController
public abstract class EmployeeController {

  public abstract List<EmployeeDTO> getAll();

  public abstract StudentDTO searchSinhVien(long id);

  public abstract List<StudentDTO> searchSinhVienByKhoaId(long id);

  public abstract List<StudentDTO> findSinhVien();

  public abstract List<StudentDTO> searchSinhVienBySinhVien(StudentRequest student);
}
