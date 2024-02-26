package com.example.springboot.moudle.employee.api.Impl;

import com.example.springboot.moudle.employee.model.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {

//    @Autowired
//    private BookRepository repository;

    @GetMapping("/{id}")
    public EmployeeDTO findById(@PathVariable long id) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(3);
        employeeDTO.setName("Nguyen Van " + 3);
        return employeeDTO;
    }

    @GetMapping("/")
    public Collection<EmployeeDTO> findBooks() {
        List<EmployeeDTO> listEmployee = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            EmployeeDTO employeeDTO = new EmployeeDTO();
            employeeDTO.setId(i);
            employeeDTO.setName("Nguyen Van " + i);
            listEmployee.add(employeeDTO);
        }

        return listEmployee;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeDTO updateEmployeeDTO(
            @PathVariable("id") final String id, @RequestBody final EmployeeDTO EmployeeDTO) {
        return EmployeeDTO;
    }
}