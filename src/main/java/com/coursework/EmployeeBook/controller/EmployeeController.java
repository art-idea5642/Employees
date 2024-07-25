package com.coursework.EmployeeBook.controller;

import com.coursework.EmployeeBook.dto.Employee;
import com.coursework.EmployeeBook.service.EmployeeService;
import com.coursework.EmployeeBook.exceptions.EmployeeNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/departments")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/max-salary")
    public Employee getEmployeeWithMaxSalary(@RequestParam String departmentId) {
        return employeeService.getEmployeeWithMaxSalary(departmentId);
    }

    @GetMapping("/min-salary")
    public Employee getEmployeeWithMinSalary(@RequestParam String departmentId) {
        return employeeService.getEmployeeWithMinSalary(departmentId);
    }

    @GetMapping("/all")
    public List<Employee> getAllEmployeesByDepartment(@RequestParam(required = false) String departmentId) {
        if (departmentId != null) {
            return employeeService.getAllEmployeesByDepartment(departmentId);
        } else {
            // Если departmentId не указан, возвращаем всех сотрудников, разделённых по отделам
            Map<String, List<Employee>> employeesByDepartment = employeeService.getAllEmployeesGroupedByDepartment();
            return employeesByDepartment.values().stream()
                    .flatMap(List::stream)
                    .collect(Collectors.toList());
        }
    }
}



