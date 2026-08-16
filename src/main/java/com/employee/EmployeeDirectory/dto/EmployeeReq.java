package com.employee.EmployeeDirectory.dto;

import com.employee.EmployeeDirectory.entity.Department;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeReq {
    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 15,message = "Name must be between 3 to 15 characters only")
    private String name;

    @NotBlank(message = "Email is required")
    @Email
    @Size(max = 50)
    private String email;

    @NotNull(message = "Enter a valid department")
    private Department department;

    @NotNull(message = "Salary is required")
    @Positive(message = "Salary must be greater than 0")
    private BigDecimal salary;

}
