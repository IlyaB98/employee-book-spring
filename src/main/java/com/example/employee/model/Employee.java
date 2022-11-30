package com.example.employee.model;

import java.util.Objects;

public class Employee {

    private static int counter;
    private final int id;
    private final String firstName;
    private final String lastName;
    private final int department;
    private final int salary;

    public Employee(String firstName, String lastName, int department1, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department1;
        this.salary = salary;

        this.id = ++counter;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", department=" + department +
                ", department=" + department +
                ", salary=" + salary +
                '}';
    }
}
