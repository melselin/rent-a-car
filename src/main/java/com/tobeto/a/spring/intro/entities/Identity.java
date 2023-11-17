package com.tobeto.a.spring.intro.entities;

import jakarta.persistence.*;

import java.util.List;

@Table(name = "identities")
@Entity
public class Identity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "national_id_or_passport_number")
    private String nationalIdOrPassportNum;

    @Column(name = "driver_licence_number")
    private String driverLicenceNum;


    @OneToOne(mappedBy = "identity")
    private List<Employee> employees;

    @OneToOne(mappedBy = "identity")
    private List<Customer> customers;
}
