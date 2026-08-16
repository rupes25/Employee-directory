package com.employee.EmployeeDirectory.dto;

import com.employee.EmployeeDirectory.entity.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRes {
    private Long id;
    private String name;
    private String email;
    private Department department;
    private BigDecimal salary;
}
