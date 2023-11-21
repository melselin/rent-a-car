package com.tobeto.a.spring.intro.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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


    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
