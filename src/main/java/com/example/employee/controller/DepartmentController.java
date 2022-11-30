package com.example.employee.controller;

import com.example.employee.model.Employee;
import com.example.employee.service.DepartmentService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/department/{id}/employees")
    public Collection<Employee> getListEmployeesByDepartment(@PathVariable int id) {
        return departmentService.listEmployeeByDepartment(id);
    }

    @GetMapping("/department/{id}/salary/sum")
    public int getSumSalaryByDepartment(@PathVariable int id) {
        return departmentService.sumSalaryByDepartment(id);
    }

    @GetMapping("/department/{id}/salary/max")
    public int getMaxSalaryByDepartment(@PathVariable int id) {
        return departmentService.maxSalaryByDepartment(id);
    }

    @GetMapping("/department/{id}/salary/min")
    public int getMinSalaryByDepartment(@PathVariable int id) {
        return departmentService.minSalaryByDepartment(id);
    }

    @GetMapping("/department/employees")
    public Map<Integer, List<Employee>> getGroupedEmployeesByDepartment() {
        return departmentService.groupedEmployeesByDepartment();
    }
}
