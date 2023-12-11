package com.tobeto.a.spring.intro.services.concretes;

import com.tobeto.a.spring.intro.entities.Address;
import com.tobeto.a.spring.intro.entities.Department;
import com.tobeto.a.spring.intro.entities.Employee;
import com.tobeto.a.spring.intro.repositories.EmployeeRepository;
import com.tobeto.a.spring.intro.services.abstracts.AddressService;
import com.tobeto.a.spring.intro.services.abstracts.DepartmentService;
import com.tobeto.a.spring.intro.services.abstracts.EmployeeService;
import com.tobeto.a.spring.intro.services.dtos.employee.requests.AddEmployeeRequest;
import com.tobeto.a.spring.intro.services.dtos.employee.requests.DeleteEmployeeRequest;
import com.tobeto.a.spring.intro.services.dtos.employee.requests.UpdateEmployeeRequest;
import com.tobeto.a.spring.intro.services.dtos.employee.responses.GetListEmployeeResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class EmployeeManager implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final AddressService addressService;
    private final DepartmentService departmentService;

    @Override
    public List<Employee> getByName(String name) {
        return employeeRepository.findByNameStartingWith(name);
    }

    @Override
    public List<GetListEmployeeResponse> getByNameDto(String name) {
        return employeeRepository.findByNameDto(name);
    }

    @Override
    public void add(AddEmployeeRequest request) {
        if(employeeRepository.existsEmployeeByName(request.getName())&&employeeRepository.existsEmployeeBySurname(request.getSurname())){
            throw new RuntimeException("Bu çalışan zaten mevcut");
        }
        Employee employee = new Employee();
        employee.setId(request.getId());
        employee.setName(request.getName());
        employee.setSurname(request.getSurname());
        employee.setAge(request.getAge());
        Address address = addressService.getById(request.getId());
        employee.setAddress(address);
        Department department = departmentService.getById(request.getId());
        employee.setDepartment(department);
        employeeRepository.save(employee);

    }

    @Override
    public void update(UpdateEmployeeRequest request) {
        if(employeeRepository.existsEmployeeByName(request.getName())&&employeeRepository.existsEmployeeBySurname(request.getSurname())){
            throw new RuntimeException("Bu çalışan zaten mevcut");
        }
        Employee employeeToUpdate = employeeRepository.findById(request.getId()).orElseThrow();
        employeeToUpdate.setName(request.getName());
        employeeToUpdate.setSurname(request.getSurname());
        employeeToUpdate.setAge(request.getAge());
        Address address = addressService.getById(request.getId());
        employeeToUpdate.setAddress(address);
        Department department = departmentService.getById(request.getId());
        employeeToUpdate.setDepartment(department);
        employeeRepository.save(employeeToUpdate);

    }

    @Override
    public void delete(DeleteEmployeeRequest request) {
        Employee employeeToDelete = employeeRepository.findById(request.getId()).orElseThrow();
        employeeRepository.delete(employeeToDelete);

    }

    @Override
    public Employee getById(int id) {
        return employeeRepository.findById(id).orElseThrow();
    }
}
