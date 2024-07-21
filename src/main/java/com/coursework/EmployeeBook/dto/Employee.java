package com.coursework.EmployeeBook.dto;
import java.util.Objects;

public class Employee {
    private final String firstName;
    private final String surname;

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.surname = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(surname, employee.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, surname);
    }

    @Override
    public String toString() {
        return firstName + surname;
    }
}