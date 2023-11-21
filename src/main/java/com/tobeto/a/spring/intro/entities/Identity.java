package com.tobeto.a.spring.intro.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Table(name = "identities")
@Entity
@Getter
@Setter
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
    @JsonIgnore
    private List<Employee> employees;

    @OneToOne(mappedBy = "identity")
    @JsonIgnore
    private List<Customer> customers;
}
