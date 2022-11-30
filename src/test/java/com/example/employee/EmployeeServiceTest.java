package com.example.employee;

import com.example.employee.model.Employee;
import com.example.employee.record.EmployeeRequest;
import com.example.employee.service.EmployeeNotFoundException;
import com.example.employee.service.EmployeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class EmployeeServiceTest {
    private final EmployeeService employeeService = new EmployeeService();
    private Map<Integer, Employee> employees = employeeService.getEmployees();

    @BeforeEach
    public void setUp() {
        Employee employee1 = new Employee("Name1", "LastName1", 1, 1000);
        Employee employee2 = new Employee("Name2", "LastName2", 2, 2000);
        Employee employee3 = new Employee("Name3", "LastName3", 3, 3000);

        employees.put(employee1.getId(), employee1);
        employees.put(employee2.getId(), employee2);
        employees.put(employee3.getId(), employee3);
    }

    @Test
    public void addEmployee() {
        EmployeeRequest employee1 = new EmployeeRequest("Name1", "LastName1", 1, 1000);
        EmployeeRequest employee1Copy = new EmployeeRequest("Name1", "LastName1", 1, 1000);
        EmployeeRequest employee2 = new EmployeeRequest("Name2", "LastName2", 2, 2000);
        EmployeeRequest employee3 = new EmployeeRequest("Name3", "LastName3", 3, 3000);

        employeeService.addEmployee(employee1);
//        employeeService.addEmployee(employee1Copy);
        employeeService.addEmployee(employee2);
        employeeService.addEmployee(employee3);

        Assertions.assertEquals(6, employeeService.getEmployees().size());
    }

    @Test
    public void deleteEmployee() {
        Employee employee = new Employee("Name1", "LastName1", 1, 1000);
        employeeService.deleteEmployee(employee);
        Assertions.assertEquals(2, employeeService.getEmployees().size());
    }

    @Test
    public void getAllEmployees() {
        Assertions.assertEquals(3, employeeService.getAllEmployees().size());
    }

    @Test
    public void getSalarySum() {
        Assertions.assertEquals(6000, employeeService.getSalarySum());
    }

    @Test
    public void getMinSalaryByEmployees() throws EmployeeNotFoundException {
        Assertions.assertEquals(employees.get(1), employeeService.getMinSalaryByEmployees());
    }

    @Test
    public void getMaxSalaryByEmployees() throws EmployeeNotFoundException {
        Assertions.assertEquals(employees.get(3), employeeService.getMaxSalaryByEmployees());
    }

    @Test
    public void getAllEmployeesSalaryMoreAverage() {
        Collection<Employee> employeeList = new ArrayList<>();
        employeeList.add(employees.get(3));
        Assertions.assertEquals(employeeList, employeeService.getAllEmployeesSalaryMoreAverage());
    }

    @Test
    public void getAllEmployeesSalaryLessAverage() {
        Collection<Employee> employeeList = new ArrayList<>();
        employeeList.add(employees.get(1));
        Assertions.assertEquals(employeeList, employeeService.getAllEmployeesSalaryLessAverage());
    }

}
