package com.tobeto.a.spring.intro.entities;


import jakarta.persistence.*;

import java.util.List;

@Table(name = "customers")
@Entity
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


    @ManyToOne
    @JoinColumn(name = "phone_number_id")
    private PhoneNumber phoneNumber;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToOne
    @JoinColumn(name = "identity_id")
    private Identity identity;

    @ManyToOne
    @JoinColumn(name = "rent_detail_id")
    private RentDetail rentDetail;

    @OneToMany(mappedBy = "customer")
    private List<Payment> payments;

}
