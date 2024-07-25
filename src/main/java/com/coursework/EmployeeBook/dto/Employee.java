package com.coursework.EmployeeBook.dto;

import java.util.Objects;

public class Employee {
    private final String firstName;
    private final String surname;
    private final double salary; // Зарплата сотрудника
    private final String departmentId; // Идентификатор отдела

    public Employee(String firstName, String surname, double salary, String departmentId) {
        this.firstName = firstName;
        this.surname = surname;
        this.salary = salary;
        this.departmentId = departmentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public double getSalary() {
        return salary;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Double.compare(employee.salary, salary) == 0 &&
                firstName.equals(employee.firstName) &&
                surname.equals(employee.surname) &&
                departmentId.equals(employee.departmentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, surname, salary, departmentId);
    }

    @Override
    public String toString() {
        return firstName + " " + surname + " (Salary: " + salary + ", Department: " + departmentId + ")";
    }
}

