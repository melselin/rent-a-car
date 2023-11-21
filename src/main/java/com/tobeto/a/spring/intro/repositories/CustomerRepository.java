package com.tobeto.a.spring.intro.repositories;

import com.tobeto.a.spring.intro.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
