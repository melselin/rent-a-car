package com.tobeto.a.spring.intro.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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

    @ManyToOne
    @JoinColumn(name = "gear_shift_type_id")
    private GearShiftType gearShiftType;

    @ManyToOne
    @JoinColumn(name = "color_id")
    private Color color;

}
