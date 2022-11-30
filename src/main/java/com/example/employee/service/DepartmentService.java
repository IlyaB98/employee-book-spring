package com.example.employee.service;

import com.example.employee.model.Employee;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    private EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Collection<Employee> listEmployeeByDepartment(int department) {
        if (department <= 0) {
            throw new IllegalArgumentException("Отдел не может быть меньше или равен 0");
        }
        return employeeService.getAllEmployees()
                .stream()
                .filter(e -> e.getDepartment() == department)
                .toList();
    }

    public int sumSalaryByDepartment(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Отдел не может быть меньше или равен 0");
        }

        return employeeService.getAllEmployees().stream()
                .filter(e -> e.getDepartment() == id)
                .toList()
                .stream()
                .mapToInt(Employee::getSalary)
                .sum();
    }

    public int maxSalaryByDepartment(int id) {
        return employeeService.getAllEmployees().stream()
                .filter(e -> e.getDepartment() == id)
                .toList()
                .stream()
                .mapToInt(Employee::getSalary)
                .max()
                .orElse(0);
    }

    public int minSalaryByDepartment(int id) {
        return employeeService.getAllEmployees().stream()
                .filter(e -> e.getDepartment() == id)
                .toList()
                .stream()
                .mapToInt(Employee::getSalary)
                .min()
                .orElse(0);
    }

    public Map<Integer, List<Employee>> groupedEmployeesByDepartment() {
        Map<Integer, List<Employee>> collectionMap = employeeService.getEmployees().values().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        return collectionMap;
    }
}
