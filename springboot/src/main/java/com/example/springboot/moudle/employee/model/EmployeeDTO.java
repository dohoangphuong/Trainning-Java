package com.example.springboot.moudle.employee.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EmployeeDTO {
    /**
     * ID
     */
    private long Id;
    /**
     * Name
     */
    private String name;
//    private LocalDateTime birthday;
}
