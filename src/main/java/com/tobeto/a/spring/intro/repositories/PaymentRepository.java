package com.tobeto.a.spring.intro.repositories;

import com.tobeto.a.spring.intro.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
