package com.tobeto.a.spring.intro.repositories;

import com.tobeto.a.spring.intro.entities.Employee;
import com.tobeto.a.spring.intro.services.dtos.employee.responses.GetListEmployeeResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    List<Employee> findByName(String name);

    boolean existsEmployeeByName(String name);

    boolean existsEmployeeBySurname(String surname);

}
