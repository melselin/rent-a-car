package com.tobeto.a.spring.intro.repositories;

import com.tobeto.a.spring.intro.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Integer> {

}
