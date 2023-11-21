package com.tobeto.a.spring.intro.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name = "gear_shift_types")
@Entity
@Getter
@Setter
public class GearShiftType {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "type")
    private String type;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
