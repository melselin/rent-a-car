package com.tobeto.a.spring.intro.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Table(name = "employees")
@Entity
@Getter
@Setter
public class Employee {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "age")
    private int age;

    @OneToMany(mappedBy = "employee")
    private List<Address> addresses;

    @OneToMany(mappedBy = "employee")
    private List<PhoneNumber> phoneNumbers;

    @OneToMany(mappedBy = "employee")
    private List<Identity> identities;

    @OneToMany(mappedBy = "employee")
    private List<Department> departments;

    @OneToMany(mappedBy = "employee")
    private List<RentDetail> rentDetails;

}
