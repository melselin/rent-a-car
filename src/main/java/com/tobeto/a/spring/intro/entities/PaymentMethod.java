package com.tobeto.a.spring.intro.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Table(name = "payment_methods")
@Entity
@Getter
@Setter
public class PaymentMethod {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "method")
    private String method;

    @OneToMany(mappedBy = "paymentMethod")
    private List<Payment> payments;
}
