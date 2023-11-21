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

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToOne
    @JoinColumn(name = "phone_id")
    private PhoneNumber phoneNumber;

    @ManyToOne
    @JoinColumn(name = "identity_id")
    private Identity identity;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "rent_detail_id")
    private RentDetail rentDetail;

}
