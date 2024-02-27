package com.example.template.moudle.employee.api.Impl;

import com.example.template.common.Validate.Constant;
import com.example.template.moudle.employee.api.EmployeeApi;
import com.example.template.moudle.employee.controller.EmployeeController;
import com.example.template.moudle.employee.model.EmployeeDTO;
import com.example.template.moudle.employee.model.StudentDTO;
import com.example.template.moudle.employee.model.StudentRequest;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
public class EmployeeApiImpl extends EmployeeApi {
  @Autowired private EmployeeController employeeController;

  public ResponseEntity<List<EmployeeDTO>> getAll() {
    try {
      List<EmployeeDTO> listEmployee = employeeController.getAll();
      return new ResponseEntity<List<EmployeeDTO>>(listEmployee, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<List<EmployeeDTO>>(
          new ArrayList<EmployeeDTO>(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  public ResponseEntity<StudentDTO> searchSinhVien(long id) {
    try {
      StudentDTO listStudent = employeeController.searchSinhVien(id);
      return new ResponseEntity<StudentDTO>(listStudent, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<StudentDTO>(new StudentDTO(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  public ResponseEntity<List<StudentDTO>> searchSinhVienByKhoaId(long id) {
    try {
      List<StudentDTO> listStudent = employeeController.searchSinhVienByKhoaId(id);
      return new ResponseEntity<List<StudentDTO>>(listStudent, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<List<StudentDTO>>(
          new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  public ResponseEntity<List<StudentDTO>> findSinhVien() {
    try {
      List<StudentDTO> listStudentDTO = employeeController.findSinhVien();
      return new ResponseEntity<List<StudentDTO>>(listStudentDTO, HttpStatus.OK);
    } catch (Exception e) {
      log.info(e);
      return new ResponseEntity<List<StudentDTO>>(
          new ArrayList<StudentDTO>(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  public ResponseEntity<List<StudentDTO>> searchSinhVienBySinhVien(StudentRequest student) {
    try {
      List<StudentDTO> listStudentDTO = employeeController.searchSinhVienBySinhVien(student);
      return new ResponseEntity<List<StudentDTO>>(listStudentDTO, HttpStatus.OK);
    } catch (Exception e) {
      log.info(e);
      return new ResponseEntity<List<StudentDTO>>(
          new ArrayList<StudentDTO>(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  public ResponseEntity<List<StudentDTO>> searchSinhVienBySinhVien(
      long id, String name, String birthday, Integer gender, long khoaId) {
    try {
      StudentRequest student = new StudentRequest();
      student.setId(id);
      student.setName(name);
      // student.setBirthday(Timestamp.valueOf(LocalDateTime.now()));
      SimpleDateFormat dateFormat = new SimpleDateFormat(Constant.formatDate);
      student.setBirthday(new Timestamp ((dateFormat.parse(birthday)).getTime()));
      student.setGender(gender);
      student.setKhoaId(khoaId);

      List<StudentDTO> listStudentDTO = employeeController.searchSinhVienBySinhVien(student);
      return new ResponseEntity<List<StudentDTO>>(listStudentDTO, HttpStatus.OK);
    } catch (Exception e) {
      log.info(e);
      return new ResponseEntity<List<StudentDTO>>(
          new ArrayList<StudentDTO>(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
