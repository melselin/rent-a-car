package com.tobeto.a.spring.intro.repositories;

import com.tobeto.a.spring.intro.entities.Customer;
import com.tobeto.a.spring.intro.services.dtos.brand.responses.GetListBrandResponse;
import com.tobeto.a.spring.intro.services.dtos.customer.responses.GetListCustomerResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Optional<Customer> findByEmail(String email);

    List<Customer> findByNameStartingWith(String name);
    // @Query("Select new com.tobeto.a.spring.intro.services.dtos.customer.responses.GetListCustomerResponse(c.id, c.name, c.surname, c.age, new com.tobeto.a.spring.intro.services.dtos.address.responses.GetListAddressResponse(a.id, a.address)) FROM Customer c INNER JOIN c.address a WHERE c.name= :name")
    List<GetListCustomerResponse> findByName(String name);

    boolean existsCustomerByName(String name);

    boolean existsCustomerBySurname(String surname);

    List<Customer> findByAgeIsNull();

    Collection<Object> findCustomerByAge(int age);
}
