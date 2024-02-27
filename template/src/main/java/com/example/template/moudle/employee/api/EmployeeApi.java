package com.example.template.moudle.employee.api;

import com.example.template.moudle.employee.model.EmployeeDTO;
import com.example.template.moudle.employee.model.StudentDTO;
import com.example.template.moudle.employee.model.StudentRequest;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public abstract class EmployeeApi {

  @GetMapping("/all")
  public abstract ResponseEntity<List<EmployeeDTO>> getAll();

  @GetMapping("/searchAll")
  public abstract ResponseEntity<List<StudentDTO>> findSinhVien();

  @GetMapping("/searchById")
  public abstract ResponseEntity<StudentDTO> searchSinhVien(long id);

  @GetMapping("/searchByKhoaId")
  public abstract ResponseEntity<List<StudentDTO>> searchSinhVienByKhoaId(@RequestParam long id);

  @PostMapping("/searchSinhVienBySinhVien")
  public abstract ResponseEntity<List<StudentDTO>> searchSinhVienBySinhVien(
      @PathVariable StudentRequest studentRequest);

  @GetMapping("/searchSinhVienBySinhVien1")
  public abstract ResponseEntity<List<StudentDTO>> searchSinhVienBySinhVien(
      @RequestParam long id,
      @RequestParam String name,
      @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") String birthday,
      @RequestParam Integer gender,
      @RequestParam long khoaId);
}
