package com.employee.EmployeeDirectory.controller;

import com.employee.EmployeeDirectory.dto.EmployeeReq;
import com.employee.EmployeeDirectory.dto.EmployeeRes;
import com.employee.EmployeeDirectory.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeRes createEmployee(@RequestBody EmployeeReq req) {
       return employeeService.createEmployee(req);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    public List<EmployeeRes> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public EmployeeRes findById(@PathVariable Long id) {
        return employeeService.findById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeRes updateById(@PathVariable Long id,@RequestBody EmployeeReq req) {
        return employeeService.updateById(id,req);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteById(@PathVariable Long id) {
        employeeService.deleteById(id);
        return "User deleted";
    }
}
