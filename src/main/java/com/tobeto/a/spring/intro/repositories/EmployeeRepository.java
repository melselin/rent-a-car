package com.tobeto.a.spring.intro.repositories;

import com.tobeto.a.spring.intro.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
