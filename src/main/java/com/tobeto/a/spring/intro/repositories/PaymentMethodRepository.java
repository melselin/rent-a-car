package com.tobeto.a.spring.intro.repositories;

import com.tobeto.a.spring.intro.entities.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethod,Integer> {
}
