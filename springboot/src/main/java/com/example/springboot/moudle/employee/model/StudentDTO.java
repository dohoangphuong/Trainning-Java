package com.example.springboot.moudle.employee.model;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class StudentDTO {

    private long id;

    private String name;

    private Timestamp birthday;

    private int gender;

    private long khoaId;
}
