package com.tobeto.a.spring.intro.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "rent_details")
@Entity
public class RentDetail {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "payment_id")
    private List<Payment> payments;

    @Column(name = "total_rent_day")
    private int totalRentDay;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private List<Customer> customers;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private List<Product> products;

    @Column(name = "rent_start_date")
    private LocalDateTime rentStartDate;

    @Column(name = "rent_end_date")
    private LocalDateTime rentEndDate;

    @OneToMany(mappedBy = "employee_id")
    private List<Employee> employees;
}
