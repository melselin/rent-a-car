package com.tobeto.a.spring.intro.repositories;

import com.tobeto.a.spring.intro.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
