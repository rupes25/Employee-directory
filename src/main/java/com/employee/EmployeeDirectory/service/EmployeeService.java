package com.employee.EmployeeDirectory.service;

import com.employee.EmployeeDirectory.dto.EmployeeReq;
import com.employee.EmployeeDirectory.dto.EmployeeRes;

import java.util.List;

public interface EmployeeService {
    //create
    public EmployeeRes createEmployee(EmployeeReq req);

    //read
    public List<EmployeeRes>findAll();

    public EmployeeRes findById(Long id);

    //update
    public EmployeeRes updateById(Long id, EmployeeReq req);

    //delete

    public String deleteById(Long id);
}
