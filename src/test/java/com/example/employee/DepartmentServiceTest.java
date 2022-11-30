package com.example.employee;

import com.example.employee.model.Employee;
import com.example.employee.service.DepartmentService;
import com.example.employee.service.EmployeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collection;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {
    @Mock
    private EmployeeService employeeService;
    private DepartmentService departmentService;

    @BeforeEach
    public void setUp() {
        departmentService = new DepartmentService(employeeService);
    }

    @Test
    public void listEmployeeByDepartment() {
        Collection<Employee> employeeCollection = new ArrayList<>();
        Employee employee = new Employee("Name1", "LastName1", 1, 1000);
        employeeCollection.add(employee);

        Mockito.when(employeeService.getAllEmployees()).thenReturn(employeeCollection);
        Assertions.assertEquals(departmentService.listEmployeeByDepartment(1), employeeCollection);
    }

    @Test
    public void sumSalaryByDepartment() {
        Collection<Employee> employeeCollection = new ArrayList<>();
        Employee employee = new Employee("Name1", "LastName1", 1, 1000);
        Employee employee2 = new Employee("Name2", "LastName2", 1, 2000);
        employeeCollection.add(employee);
        employeeCollection.add(employee2);

        Mockito.when(employeeService.getAllEmployees()).thenReturn(employeeCollection);
        Assertions.assertEquals(departmentService.sumSalaryByDepartment(1), 3000);
    }

    @Test
    public void maxSalaryByDepartment() {
        Collection<Employee> employeeCollection = new ArrayList<>();
        Employee employee = new Employee("Name1", "LastName1", 1, 1000);
        Employee employee2 = new Employee("Name2", "LastName2", 1, 2000);
        employeeCollection.add(employee);
        employeeCollection.add(employee2);

        Mockito.when(employeeService.getAllEmployees()).thenReturn(employeeCollection);
        Assertions.assertEquals(departmentService.maxSalaryByDepartment(1), 2000);
    }

    @Test
    public void minSalaryByDepartment() {
        Collection<Employee> employeeCollection = new ArrayList<>();
        Employee employee = new Employee("Name1", "LastName1", 1, 1000);
        Employee employee2 = new Employee("Name2", "LastName2", 1, 2000);
        employeeCollection.add(employee);
        employeeCollection.add(employee2);

        Mockito.when(employeeService.getAllEmployees()).thenReturn(employeeCollection);
        Assertions.assertEquals(departmentService.minSalaryByDepartment(1), 1000);
    }
}
