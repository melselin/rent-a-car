package com.tobeto.a.spring.intro.services.concretes;

import com.tobeto.a.spring.intro.entities.Department;
import com.tobeto.a.spring.intro.repositories.DepartmentRepository;
import com.tobeto.a.spring.intro.services.abstracts.DepartmentService;
import com.tobeto.a.spring.intro.services.dtos.department.requests.AddDepartmentRequest;
import com.tobeto.a.spring.intro.services.dtos.department.requests.DeleteDepartmentRequest;
import com.tobeto.a.spring.intro.services.dtos.department.requests.UpdateDepartmentRequest;
import com.tobeto.a.spring.intro.services.dtos.department.responses.GetListDepartmentResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class DepartmentManager implements DepartmentService {

    private final DepartmentRepository departmentRepository;


    @Override
    public List<Department> getByName(String name) {
        return departmentRepository.findAll();
    }

    @Override
    public void add(AddDepartmentRequest request) {
        if(departmentRepository.existsDepartmentByName(request.getName())){
            throw new RuntimeException("Bu departman zaten mevcut");
        }
        Department department = new Department();
        department.setName(request.getName());
        departmentRepository.save(department);

    }

    @Override
    public void update(UpdateDepartmentRequest request) {
        if(departmentRepository.existsDepartmentByName(request.getName())){
            throw new RuntimeException("Bu departman zaten mevcut");
        }
        Department departmentToUpdate = departmentRepository.findById(request.getId()).orElseThrow();
        departmentToUpdate.setName(request.getName());
        departmentRepository.save(departmentToUpdate);

    }

    @Override
    public void delete(DeleteDepartmentRequest request) {
        Department departmentToDelete = departmentRepository.findById(request.getId()).orElseThrow();
        departmentRepository.delete(departmentToDelete);

    }

    @Override
    public Department getById(int id) {
        return departmentRepository.findById(id).orElseThrow();
    }
}
