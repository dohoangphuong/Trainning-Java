package com.example.springboot.moudle.employee.api.Impl;

import com.example.springboot.moudle.employee.api.EmployeeApi;
import com.example.springboot.moudle.employee.controller.EmployeeController;
import com.example.springboot.moudle.employee.model.EmployeeDTO;
import com.example.springboot.moudle.employee.model.StudentDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@RestController
public class EmployeeApiImpl extends EmployeeApi {
    @Autowired
    private EmployeeController employeeController;

    public ResponseEntity<List<EmployeeDTO>> getAll() {
        try {
            List<EmployeeDTO> listEmployee = employeeController.getAll();
            return new ResponseEntity<List<EmployeeDTO>>(listEmployee, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<List<EmployeeDTO>>(new ArrayList<EmployeeDTO>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<StudentDTO> searchSinhVien(long id) {
        try {
            StudentDTO listEmployee = employeeController.searchSinhVien(id);
            return new ResponseEntity<StudentDTO>(listEmployee, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<StudentDTO>(new StudentDTO(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<StudentDTO>> findSinhVien() {
        try {
            List<StudentDTO> listStudentDTO = employeeController.findSinhVien();
            return new ResponseEntity<List<StudentDTO>>(listStudentDTO, HttpStatus.OK);
        } catch (Exception e) {
            log.info(e);
            return new ResponseEntity<List<StudentDTO>>(new ArrayList<StudentDTO>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
