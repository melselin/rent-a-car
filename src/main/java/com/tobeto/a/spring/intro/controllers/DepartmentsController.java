package com.tobeto.a.spring.intro.controllers;

import com.tobeto.a.spring.intro.entities.Department;
import com.tobeto.a.spring.intro.repositories.DepartmentRepository;
import com.tobeto.a.spring.intro.services.abstracts.DepartmentService;
import com.tobeto.a.spring.intro.services.dtos.department.requests.AddDepartmentRequest;
import com.tobeto.a.spring.intro.services.dtos.department.requests.DeleteDepartmentRequest;
import com.tobeto.a.spring.intro.services.dtos.department.requests.UpdateDepartmentRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/departments")
public class DepartmentsController {
    private final DepartmentRepository departmentRepository;
    private final DepartmentService departmentService;
    @GetMapping
    public List<Department> getAll(){
        List<Department> departments = departmentRepository.findAll();
        return departments;
    }

    @GetMapping("{id}")
    public Department getById(@PathVariable int id){
        return departmentRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody @Valid AddDepartmentRequest request){
        departmentService.add(request);
    }

    @DeleteMapping
    public void delete(@PathVariable DeleteDepartmentRequest request){ departmentService.delete(request);
    }

    @PutMapping
    public void update(@PathVariable int id, @RequestBody @Valid UpdateDepartmentRequest request){ departmentService.update(request);

    }
}
