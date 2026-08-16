package com.employee.EmployeeDirectory.service;

import com.employee.EmployeeDirectory.dto.EmployeeReq;
import com.employee.EmployeeDirectory.dto.EmployeeRes;
import com.employee.EmployeeDirectory.entity.Department;
import com.employee.EmployeeDirectory.entity.Employee;
//import com.employee.EmployeeDirectory.repository.EmployeeRepository;
import com.employee.EmployeeDirectory.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public EmployeeRes createEmployee(EmployeeReq req) {
        Employee employee = new Employee();
        employee.setName(req.getName());
        employee.setEmail(req.getEmail());
        employee.setDepartment(req.getDepartment());
        employee.setSalary(req.getSalary());

        Employee saved = employeeRepository.save(employee);

        return mapToDto(saved);
    }

    @Override
    public List<EmployeeRes> createEmployees(List<EmployeeReq> reqs) {
        List<Employee>employees = reqs.stream()
                .map(req -> {
                Employee employee = new Employee();
                    employee.setName(req.getName());
                    employee.setEmail(req.getEmail());
                    employee.setDepartment(req.getDepartment());
                    employee.setSalary(req.getSalary());
                    return employee;
        }).toList();

        return employeeRepository.saveAll(employees).stream().map(this::mapToDto).toList();

    }

    @Override
    public Page<EmployeeRes>findAll(Pageable pageable){
        Page<Employee>employees = employeeRepository.findAll(pageable);
        return employees.map(this::mapToDto);
    }

    @Override
    public Page<EmployeeRes> findByDepartment(Department department, Pageable pageable) {
        Page<Employee>employees = employeeRepository.findByDepartment(department,pageable);
        return employees.map(this::mapToDto);
    }

    @Override
    public List<EmployeeRes> findAll() {
        return employeeRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .toList();
    }

    @Override
    public EmployeeRes findById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(()->new RuntimeException("No user found"));
        return mapToDto(employee);
    }

    @Override
    public EmployeeRes updateById(Long id, EmployeeReq req) {
        Employee employee = employeeRepository.findById(id).orElseThrow(()->new RuntimeException("No user found"));
        employee.setName(req.getName());
        employee.setEmail(req.getEmail());
        employee.setDepartment(req.getDepartment());
        employee.setSalary(req.getSalary());
        return mapToDto(employee);
    }

    @Override
    public String deleteById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(()->new RuntimeException("No user found"));
        employeeRepository.delete(employee);
        return "User deleted";
    }

    public EmployeeRes mapToDto(Employee employee){
        return new EmployeeRes(
                employee.getId(),
                employee.getName(),
                employee.getEmail(),
                employee.getDepartment(),
                employee.getSalary()
        );
    }

}
