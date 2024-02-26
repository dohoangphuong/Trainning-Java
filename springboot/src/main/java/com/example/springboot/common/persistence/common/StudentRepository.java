package com.example.springboot.common.persistence.common;

import com.example.springboot.common.entity.Student;
import com.example.springboot.moudle.employee.model.StudentDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByID(long ID);

    List<Student> findAll();
}
