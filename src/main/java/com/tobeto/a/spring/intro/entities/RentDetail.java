package com.tobeto.a.spring.intro.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Table(name = "rent_details")
@Entity
@Getter
@Setter
public class RentDetail {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;

    @Column(name = "total_rent_day")
    private int totalRentDay;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "rent_start_date")
    private LocalDate rentStartDate;

    @Column(name = "rent_end_date")
    private LocalDate rentEndDate;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
