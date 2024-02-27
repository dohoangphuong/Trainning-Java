package com.example.template.moudle.employee.controller.Impl;

import com.example.template.moudle.employee.controller.EmployeeController;
import com.example.template.moudle.employee.model.EmployeeDTO;
import com.example.template.moudle.employee.model.StudentDTO;
import com.example.template.moudle.employee.model.StudentRequest;
import com.example.template.moudle.employee.service.EmployeeService;
import java.util.List;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
public class EmployeeControllerImpl extends EmployeeController {
  @Autowired private EmployeeService employeeService;

  public List<EmployeeDTO> getAll() {
    return employeeService.getAll();
  }

  public StudentDTO searchSinhVien(long id) {

    return employeeService.searchSinhVien(id);
  }

  public List<StudentDTO> searchSinhVienByKhoaId(long id) {

    return employeeService.searchSinhVienByKhoaId(id);
  }

  public List<StudentDTO> findSinhVien() {

    return employeeService.findSinhVien();
  }

  public List<StudentDTO> searchSinhVienBySinhVien(StudentRequest student) {

    return employeeService.searchSinhVienBySinhVien(student);
  }
}
