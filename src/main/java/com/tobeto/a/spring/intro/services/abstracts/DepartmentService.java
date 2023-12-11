package com.tobeto.a.spring.intro.services.abstracts;

import com.tobeto.a.spring.intro.entities.Department;
import com.tobeto.a.spring.intro.services.dtos.department.requests.AddDepartmentRequest;
import com.tobeto.a.spring.intro.services.dtos.department.requests.DeleteDepartmentRequest;
import com.tobeto.a.spring.intro.services.dtos.department.requests.UpdateDepartmentRequest;
import com.tobeto.a.spring.intro.services.dtos.department.responses.GetListDepartmentResponse;

import java.util.List;

public interface DepartmentService {
    List<Department> getByName(String name);

    void add(AddDepartmentRequest request);
    void update(UpdateDepartmentRequest request);
    void delete(DeleteDepartmentRequest request);
    Department getById(int id);

}
