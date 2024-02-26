package com.example.springboot.common.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "KHOA")
public class Khoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long ID;

    @Column(name = "NAME")
    public String NAME;

    @OneToMany(mappedBy="KHOA")
    public Set<Student> listSV = new HashSet<>();
}
