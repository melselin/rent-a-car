package com.tobeto.a.spring.intro.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name = "payments")
@Entity
@Getter
@Setter
public class Payment {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "amount")
    private double amount;

    @Column(name = "discount")
    private double discount;

    @OneToOne
    @JoinColumn(name = "payment_method_id")
    @JsonIgnore
    private PaymentMethod paymentMethod;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
