package com.tobeto.a.spring.intro.repositories;

import com.tobeto.a.spring.intro.entities.Product;
import com.tobeto.a.spring.intro.services.dtos.product.responses.GetListProductResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {

    @Query("Select new com.tobeto.a.spring.intro.services.dtos.product.responses.GetListProductResponse" +
            "( p.id, p.model, p.dailyPrice, p.description, p.licencePlate, new com.tobeto.a.spring.intro.services.dtos.brand.responses.GetListBrandResponse(b.id, b.name)  ) " +
            "from Product p INNER JOIN p.brand b")

    List<GetListProductResponse> getAll();
}
