package com.example.springboot.moudle.employee.api;

import com.example.springboot.moudle.employee.model.EmployeeDTO;
import com.example.springboot.moudle.employee.model.StudentDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public abstract class EmployeeApi {

    @GetMapping("/all")
    public abstract ResponseEntity<List<EmployeeDTO>> getAll();


    @GetMapping("/search")
    public abstract ResponseEntity<StudentDTO> searchSinhVien(@PathVariable long id);

    @GetMapping("/findAll")
    public abstract ResponseEntity<List<StudentDTO>> findSinhVien();
}
