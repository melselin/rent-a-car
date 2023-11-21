package com.tobeto.a.spring.intro.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name = "addresses")
@Entity
@Getter
@Setter
public class Address {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "address")
    private String address;


    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
