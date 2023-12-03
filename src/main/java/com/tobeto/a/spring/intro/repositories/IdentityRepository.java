package com.tobeto.a.spring.intro.repositories;

import com.tobeto.a.spring.intro.entities.Identity;
import com.tobeto.a.spring.intro.services.dtos.identity.responses.GetListIdentityResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IdentityRepository extends JpaRepository<Identity, Integer> {
    List<Identity> findByNationalIdStartingWith(String nationalId);

    @Query("Select new com.tobeto.a.spring.intro.services.dtos.identity.responses.GetListIdentityResponse(i.id, i.nationalId) " +
            "From Identity i WHERE i.nationalId = :nationalId")
    List<GetListIdentityResponse> findByNationalId(String nationalId);
}
