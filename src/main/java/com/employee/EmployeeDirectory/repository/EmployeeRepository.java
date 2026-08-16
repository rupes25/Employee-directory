package com.employee.EmployeeDirectory.repository;

import com.employee.EmployeeDirectory.entity.Department;
import com.employee.EmployeeDirectory.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    Page<Employee>findByDepartment(Department department,Pageable pageable);
}
