package com.tobeto.a.spring.intro.controllers;

import com.tobeto.a.spring.intro.entities.Department;
import com.tobeto.a.spring.intro.repositories.DepartmentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/departments")
public class DepartmentsController {
    private final DepartmentRepository departmentRepository;

    public DepartmentsController(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

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
    public void add(@RequestBody Department department){
        departmentRepository.save(department);
    }

    @DeleteMapping
    public void delete(@PathVariable int id){
        Department departmentToDelete = departmentRepository.findById(id).orElseThrow();
        departmentRepository.delete(departmentToDelete);
    }

    @PutMapping
    public void update(@PathVariable int id, @RequestBody Department department){
        Department departmentToUpdate = departmentRepository.findById(id).orElseThrow();
        departmentToUpdate.setDepartmentName(department.getDepartmentName());
        departmentRepository.save(departmentToUpdate);



    }
}
