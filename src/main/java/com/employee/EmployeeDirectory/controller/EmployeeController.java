package com.employee.EmployeeDirectory.controller;

import com.employee.EmployeeDirectory.dto.EmployeeReq;
import com.employee.EmployeeDirectory.dto.EmployeeRes;
import com.employee.EmployeeDirectory.entity.Department;
import com.employee.EmployeeDirectory.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    //create endpoint
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeRes createEmployee(@Valid @RequestBody EmployeeReq req) {
       return employeeService.createEmployee(req);
    }

    //bulk adding endpoint
    @PostMapping("/bulk")
    @ResponseStatus(HttpStatus.CREATED)
    public List<EmployeeRes> createEmployees(@Valid @RequestBody List<EmployeeReq> reqs) {
        return employeeService.createEmployees(reqs);
    }

    //page wise visible
    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    public Page<EmployeeRes> findAll(Pageable pageable) {
        return employeeService.findAll(pageable);
    }


    //filtering department wise

    @GetMapping("/department/{department}")
    public Page<EmployeeRes> findByDepartment(
            @PathVariable Department department,
            Pageable pageable
    ) {
        return employeeService.findByDepartment(
                department,
                pageable
        );
    }

    //id wise visible
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public EmployeeRes findById(@PathVariable Long id) {
        return employeeService.findById(id);
    }

    //update
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeRes updateById(@PathVariable Long id,@RequestBody EmployeeReq req) {
        return employeeService.updateById(id,req);
    }

    //delete
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteById(@PathVariable Long id) {
        employeeService.deleteById(id);
        return "User deleted";
    }
}
