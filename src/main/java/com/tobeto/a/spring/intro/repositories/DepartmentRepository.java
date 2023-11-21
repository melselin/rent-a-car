package com.tobeto.a.spring.intro.repositories;

import com.tobeto.a.spring.intro.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Integer> {
}
