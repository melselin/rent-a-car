package com.tobeto.a.spring.intro.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name = "departments")
@Entity
@Getter
@Setter
public class Department {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "department_name")
    private String departmentName;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;


}
