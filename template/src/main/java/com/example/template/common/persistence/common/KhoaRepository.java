package com.example.template.common.persistence.common;

import com.example.template.common.entity.Khoa;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KhoaRepository extends JpaRepository<Khoa, Long> {
  List<Khoa> findByID(long ID);

  List<Khoa> findAll();
}
