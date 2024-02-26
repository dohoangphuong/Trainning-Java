package com.example.springboot.common.persistence.repository.Interface;

import com.example.springboot.common.entity.Student;
import com.example.springboot.moudle.employee.model.StudentDTO;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface IStudentRepository {
    Student findStudentByID(long id);
    List<StudentDTO> findAll();
    List<StudentDTO> findAll(Sort.Direction direction);
}
