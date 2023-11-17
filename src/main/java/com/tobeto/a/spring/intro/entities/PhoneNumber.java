package com.tobeto.a.spring.intro.entities;

import jakarta.persistence.*;

import java.util.List;

@Table(name = "phone_numbers")
@Entity
public class PhoneNumber {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "number")
    private String phoneNum;

    @OneToMany(mappedBy = "phoneNumber")
    private List<Customer> customers;

    @OneToMany(mappedBy = "phoneNumber")
    private List<Employee> employees;

}
