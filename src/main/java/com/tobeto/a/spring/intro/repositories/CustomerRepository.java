package com.tobeto.a.spring.intro.repositories;

import com.tobeto.a.spring.intro.entities.Customer;
import com.tobeto.a.spring.intro.services.dtos.brand.responses.GetListBrandResponse;
import com.tobeto.a.spring.intro.services.dtos.customer.responses.GetListCustomerResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findByNameStartingWith(String name);

    @Query("Select new com.tobeto.a.spring.intro.services.dtos.customer.responses.GetListCustomerResponse(c.id, c.name) " +
            "FROM Customer c WHERE c.name= :name")
    List<GetListCustomerResponse> findByName(String name);
}
