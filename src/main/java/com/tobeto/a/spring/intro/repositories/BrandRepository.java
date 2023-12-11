package com.tobeto.a.spring.intro.repositories;

import com.tobeto.a.spring.intro.entities.Brand;
import com.tobeto.a.spring.intro.services.dtos.brand.responses.GetListBrandResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// Generic
// Generic Typelar Reference Type olarak belirtilmelidir.
public interface BrandRepository extends JpaRepository<Brand, Integer> {

    @Query("Select new com.tobeto.a.spring.intro.services.dtos.brand.responses.GetListBrandResponse(b.id, b.name) "
            + "FROM Brand b WHERE b.name= :name")
    List<GetListBrandResponse> findByName(String name);

    boolean existsBrandByName(String name);

}
