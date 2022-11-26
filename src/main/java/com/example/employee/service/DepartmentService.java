package com.example.employee.service;

import com.example.employee.model.Employee;
import org.springframework.stereotype.Service;

import java.util.*;

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

    public Map<Integer, Collection<Employee>> groupedEmployeesByDepartment() {
        List<Integer> integerList = employeeService.getAllEmployees().stream()
                .mapToInt(Employee::getDepartment)
                .boxed()
                .toList();
        Set<Integer> departmentSet = new HashSet<>(integerList);
        Iterator<Integer> iterator = departmentSet.iterator();
        if (iterator.hasNext()) {
            Map<Integer, Collection<Employee>> employeesMap = new HashMap<>();
            employeesMap.put(iterator.next(), listEmployeeByDepartment(iterator.next()));
            return employeesMap;
        } else {
            return null;
        }
    }
}
