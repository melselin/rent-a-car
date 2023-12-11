package com.tobeto.a.spring.intro.services.abstracts;

import com.tobeto.a.spring.intro.entities.Employee;
import com.tobeto.a.spring.intro.services.dtos.employee.requests.AddEmployeeRequest;
import com.tobeto.a.spring.intro.services.dtos.employee.requests.DeleteEmployeeRequest;
import com.tobeto.a.spring.intro.services.dtos.employee.requests.UpdateEmployeeRequest;
import com.tobeto.a.spring.intro.services.dtos.employee.responses.GetListEmployeeResponse;

import java.util.List;

public interface EmployeeService {
    List<Employee> getByName(String name);
    List<GetListEmployeeResponse> getByNameDto(String name);
    void add(AddEmployeeRequest request);
    void update(UpdateEmployeeRequest request);
    void delete(DeleteEmployeeRequest request);

    Employee getById(int id);

}
