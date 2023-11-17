package com.tobeto.a.spring.intro.entities;

import jakarta.persistence.*;

import java.util.List;

@Table(name = "brands")
@Entity
public class Brand {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "brand") //!!DEĞİŞKEN İSMİ!!
    private List<Car> cars;
    // One-to-many ilişkilerde list olan değişken @onetomany
    //direkt class olan değişken @manytoone



}