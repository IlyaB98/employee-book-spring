package com.example.employee.controller;

import com.example.employee.model.Employee;
import com.example.employee.record.EmployeeRequest;
import com.example.employee.service.EmployeeNotFoundException;
import com.example.employee.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.OptionalInt;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public Collection<Employee> getAllEmployees() {
        return this.employeeService.getAllEmployees();
    }

    @PostMapping("/employee")
    public Employee createEmployee(@RequestBody EmployeeRequest employeeRequest) {
        return this.employeeService.addEmployee(employeeRequest);
    }

    @GetMapping("employees/salary/sum")
    public int getSalarySum() {
        return this.employeeService.getSalarySum();
    }

    @GetMapping("employees/salary/min")
    public Employee getMinSalaryByEmployees() throws EmployeeNotFoundException {
        return this.employeeService.getMinSalaryByEmployees();

    }

    @GetMapping("employees/salary/max")
    public Employee getMaxSalaryByEmployees() throws EmployeeNotFoundException {
        return this.employeeService.getMaxSalaryByEmployees();
    }

    @GetMapping("employees/salary/average/more")
    public Collection<Employee> getAllEmployeesSalaryMoreAverage() {
        return this.employeeService.getAllEmployeesSalaryMoreAverage();
    }

    @GetMapping("employees/salary/average/less")
    public Collection<Employee> getAllEmployeesSalaryLessAverage() {
        return this.employeeService.getAllEmployeesSalaryLessAverage();
    }
}
