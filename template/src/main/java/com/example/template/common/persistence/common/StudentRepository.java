package com.example.template.common.persistence.common;

import com.example.template.common.entity.Khoa;
import java.util.List;

import com.example.template.common.entity.SinhVien;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<SinhVien, Long> {
  List<SinhVien> findByID(long ID);

  List<SinhVien> findAll();
}
