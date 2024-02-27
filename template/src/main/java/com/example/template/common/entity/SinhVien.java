package com.example.template.common.entity;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "SINHVIEN")
public class SinhVien {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public long ID;

  @Column(name = "NAME")
  public String NAME;

  @Column(name = "BIRTHDAY")
  public Timestamp BIRTHDAY;

  @Column(name = "GENDER")
  public int GENDER;

  @ManyToOne
  @JoinColumn(name = "KHOAID")
  public Khoa KHOA;
}
