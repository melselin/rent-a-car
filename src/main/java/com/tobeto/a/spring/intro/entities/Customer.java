package com.tobeto.a.spring.intro.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Table(name = "customers")
@Entity
@Getter
@Setter
public class Customer {
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


    @OneToMany(mappedBy = "customer")
    private List<PhoneNumber> phoneNumbers;

    @OneToMany(mappedBy = "customer")
    private List<Address> addresses;

    @OneToMany(mappedBy = "customer")
    private List<Identity> identities;

    @OneToMany(mappedBy = "customer")
    private List<RentDetail> rentDetails;

    @OneToMany(mappedBy = "customer")
    //@JsonIgnore
    private List<Payment> payments;

}
