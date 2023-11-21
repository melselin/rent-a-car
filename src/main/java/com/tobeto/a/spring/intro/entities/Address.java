package com.tobeto.a.spring.intro.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Table(name = "addresses")
@Entity
@Getter
@Setter
public class Address {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "addresses")
    private String address;


    @OneToMany(mappedBy = "address")
    @JsonIgnore
    private List<Customer> customers;

    @OneToMany(mappedBy = "address")
    @JsonIgnore
    private List<Employee> employees;
}
