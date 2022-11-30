package com.example.employee.service;

import com.example.employee.model.Employee;
import com.example.employee.record.EmployeeRequest;
import org.springframework.stereotype.Service;

import java.util.*;

import static java.util.Comparator.comparingInt;

@Service
public class EmployeeService {

    private final Map<Integer, Employee> employees = new HashMap<>();

    public Collection<Employee> getAllEmployees() {
        return this.employees.values();
    }

    public Employee addEmployee(EmployeeRequest employeeRequest) {
        if (employeeRequest.getFirstName() == null || employeeRequest.getLastName() == null
                || employeeRequest.getFirstName().isEmpty() || employeeRequest.getLastName().isEmpty()) {
            throw new IllegalArgumentException("У сотрудника не заполнены поля имени");
        }
        Employee employee = new Employee(employeeRequest.getFirstName(),
                employeeRequest.getFirstName(),
                employeeRequest.getDepartment(),
                employeeRequest.getSalary());

        for (Employee current : employees.values()) {
            if (current.getFirstName().equals(employee.getFirstName())
                    && current.getLastName().equals(employee.getLastName())) {
                throw new RuntimeException("Данный сотрудник уже добавлен в лист");
            }
        }
        employees.put(employee.getId(), employee);
        return employee;

    }

    public void deleteEmployee(Employee employee) {
        for (Employee current : employees.values()) {
            if (current.getFirstName().equals(employee.getFirstName())
                    && current.getLastName().equals(employee.getLastName())) {
                employees.remove(current.getId());
                break;
            }
            throw new RuntimeException("Сотрудник не найден");
        }
    }

    public int getSalarySum() {
        return employees.values().stream()
                .mapToInt(Employee::getSalary)
                .sum();
    }

    public Employee getMinSalaryByEmployees() throws EmployeeNotFoundException {
        return employees.values().stream()
                .min(comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    public Employee getMaxSalaryByEmployees() throws EmployeeNotFoundException {
        return employees.values().stream()
                .max(comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    public Collection<Employee> getAllEmployeesSalaryMoreAverage() {
        int averageSalary = (int) employees.values().stream()
                .mapToInt(Employee::getSalary)
                .average()
                .orElse(0);

        return employees.values()
                .stream()
                .filter(e -> e.getSalary() > averageSalary)
                .toList();
    }

    public Collection<Employee> getAllEmployeesSalaryLessAverage() {
        int averageSalary = (int) employees.values()
                .stream()
                .mapToInt(Employee::getSalary)
                .average()
                .orElse(0);

        return employees.values()
                .stream()
                .filter(e -> e.getSalary() < averageSalary)
                .toList();
    }

    public Map<Integer, Employee> getEmployees() {
        return employees;
    }
}
