package com.tobeto.a.spring.intro.entities;

import jakarta.persistence.*;

import java.util.List;

@Table(name = "addresses")
@Entity
public class Address {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "addresses")
    private String address;


    @OneToMany(mappedBy = "address")
    private List<Customer> customers;

    @OneToMany(mappedBy = "address")
    private List<Employee> employees;
}
