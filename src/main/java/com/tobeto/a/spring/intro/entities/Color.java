package com.tobeto.a.spring.intro.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Table(name = "colors")
@Entity
@Getter
@Setter
public class Color {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "color")
    private String color;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
