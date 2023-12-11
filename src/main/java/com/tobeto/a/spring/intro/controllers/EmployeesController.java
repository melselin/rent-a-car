package com.tobeto.a.spring.intro.controllers;

import com.tobeto.a.spring.intro.entities.Employee;
import com.tobeto.a.spring.intro.repositories.EmployeeRepository;
import com.tobeto.a.spring.intro.services.abstracts.EmployeeService;
import com.tobeto.a.spring.intro.services.dtos.color.requests.AddColorRequest;
import com.tobeto.a.spring.intro.services.dtos.employee.requests.AddEmployeeRequest;
import com.tobeto.a.spring.intro.services.dtos.employee.requests.DeleteEmployeeRequest;
import com.tobeto.a.spring.intro.services.dtos.employee.requests.UpdateEmployeeRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/employees")
public class EmployeesController {
    private final EmployeeRepository employeeRepository;
    private final EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAll() {
        List<Employee> employees = employeeRepository.findAll();
        return employees;
    }

    @GetMapping("{id}")
    public Employee getById(@PathVariable int id) {
        return employeeRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody @Valid AddEmployeeRequest request) {
        employeeService.add(request);
    }

    @DeleteMapping
    public void delete(@PathVariable DeleteEmployeeRequest request) {
        employeeService.delete(request);
    }

    @PutMapping
    public void update(@PathVariable int id, @RequestBody @Valid UpdateEmployeeRequest request) {
        employeeService.update(request);
    }
}
