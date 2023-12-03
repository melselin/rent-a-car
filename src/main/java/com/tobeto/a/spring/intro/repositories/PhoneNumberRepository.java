package com.tobeto.a.spring.intro.repositories;

import com.tobeto.a.spring.intro.entities.PhoneNumber;
import com.tobeto.a.spring.intro.services.dtos.phoneNumber.responses.GetListPhoneNumberResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PhoneNumberRepository extends JpaRepository<PhoneNumber,Integer> {
    List<PhoneNumber> findByNumberStartingWith(String number);

    @Query("Select new com.tobeto.a.spring.intro.services.dtos.phoneNumber.responses.GetListPhoneNumberResponse(p.id, p.number) " +
            "From PhoneNumber p WHERE p.number = :number")
    List<GetListPhoneNumberResponse> findByNumber(String number);
}
