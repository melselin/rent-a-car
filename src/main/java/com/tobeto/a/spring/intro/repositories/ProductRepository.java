package com.tobeto.a.spring.intro.repositories;

import com.tobeto.a.spring.intro.entities.Product;
import com.tobeto.a.spring.intro.services.dtos.product.responses.GetListProductResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    List<Product> findByModelStartingWith(String model);

    @Query("Select new com.tobeto.a.spring.intro.services.dtos.product.responses.GetListProductResponse(p.id, p.model) " +
            "FROM Product p WHERE p.model= :model")

    List<GetListProductResponse> findByModel(String model);
}
