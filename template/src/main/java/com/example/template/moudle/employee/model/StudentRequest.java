package com.example.template.moudle.employee.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import java.sql.Timestamp;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class StudentRequest {

  @NotNull(message="Account id can not be null")
  private long id;

  @Size(min = 0, max = 255, message = "The name '${validatedValue}' must be between {min} and {max} characters long")
  private String name;

  @JsonFormat(pattern = "yyyy-MM-dd")
  private Timestamp birthday;

  private Integer gender;

  private long khoaId;
}
