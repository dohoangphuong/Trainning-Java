package com.example.template.common.persistence.repository.Interface;

import com.example.template.common.entity.SinhVien;
import com.example.template.moudle.employee.model.StudentDTO;
import java.util.List;

import com.example.template.moudle.employee.model.StudentRequest;
import org.springframework.data.domain.Sort;

public interface IStudentRepository {
  List<StudentDTO> findAll();

  List<StudentDTO> findAll(Sort.Direction direction);

  SinhVien findStudentByID(long id);

  List<StudentDTO>  findStudentByKhoaID(long id);

  List<StudentDTO>  searchSinhVienBySinhVien(StudentDTO studentDTO);
}
