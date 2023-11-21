package com.tobeto.a.spring.intro.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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

    @OneToMany(mappedBy = "gearShiftType")
    @JsonIgnore
    private List<Product> products;
}
