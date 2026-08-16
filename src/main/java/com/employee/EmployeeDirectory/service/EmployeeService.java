package com.employee.EmployeeDirectory.service;

import com.employee.EmployeeDirectory.dto.EmployeeReq;
import com.employee.EmployeeDirectory.dto.EmployeeRes;
import com.employee.EmployeeDirectory.entity.Department;
import com.employee.EmployeeDirectory.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {
    //create
    public EmployeeRes createEmployee(EmployeeReq req);

    //bulk user creation
    public List<EmployeeRes> createEmployees(List<EmployeeReq>reqs);


    //read
    public List<EmployeeRes>findAll();

    public EmployeeRes findById(Long id);

    //pagination
    public Page<EmployeeRes> findAll(Pageable pageable);

    //grouping/filtering
    public Page<EmployeeRes>findByDepartment(Department department, Pageable pageable);

    //update
    public EmployeeRes updateById(Long id, EmployeeReq req);

    //delete
    public String deleteById(Long id);
}
