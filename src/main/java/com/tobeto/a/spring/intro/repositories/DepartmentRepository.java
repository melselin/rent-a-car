package com.tobeto.a.spring.intro.repositories;

import com.tobeto.a.spring.intro.entities.Department;
import com.tobeto.a.spring.intro.services.dtos.department.responses.GetListDepartmentResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department,Integer> {
    List<Department> findByName(String name);


    boolean existsDepartmentByName(String name);

}
