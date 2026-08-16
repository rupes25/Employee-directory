package com.employee.EmployeeDirectory.repository;

import com.employee.EmployeeDirectory.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
