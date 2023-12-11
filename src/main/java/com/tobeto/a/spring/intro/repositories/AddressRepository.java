package com.tobeto.a.spring.intro.repositories;

import com.tobeto.a.spring.intro.entities.Address;
import com.tobeto.a.spring.intro.services.dtos.address.responses.GetListAddressResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address,Integer> {

    List<Address> findByNameStartingWith(String name);

}
