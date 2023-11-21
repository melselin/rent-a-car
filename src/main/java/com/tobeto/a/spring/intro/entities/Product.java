package com.tobeto.a.spring.intro.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Table(name = "products")
@Entity
@Getter
@Setter
public class Product {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @Column(name = "model")
    private String model;

    @Column(name = "daily_price")
    private double dailyPrice;

    @Column(name = "description")
    private String description;

    @Column(name = "licence_plate")
    private String licencePlate;

    @OneToMany(mappedBy = "product")
    private List<GearShiftType> gearShiftTypes;

    @OneToMany(mappedBy = "product")
    private List<Color> colors;

}
