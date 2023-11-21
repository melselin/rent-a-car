package com.tobeto.a.spring.intro.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Table(name = "phone_numbers")
@Entity
@Getter
@Setter
public class PhoneNumber {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "number")
    private String phoneNum;

    @OneToMany(mappedBy = "phoneNumber")
    @JsonIgnore
    private List<Customer> customers;

    @OneToMany(mappedBy = "phoneNumber")
    @JsonIgnore
    private List<Employee> employees;

}
