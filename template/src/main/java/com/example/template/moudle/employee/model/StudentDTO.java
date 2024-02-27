package com.example.template.moudle.employee.model;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import jdk.jfr.BooleanFlag;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class StudentDTO {

  private long id;

  private String name;

  @JsonFormat(pattern = "yyyy-MM-dd")
  private Timestamp birthday;

  @JsonFormat(shape = JsonFormat.Shape.BOOLEAN)
  private Integer gender;

  private long khoaId;
}
