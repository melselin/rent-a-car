package com.tobeto.a.spring.intro.repositories;

import com.tobeto.a.spring.intro.entities.RentDetail;
import com.tobeto.a.spring.intro.services.dtos.rentDetail.responses.GetListRentDetailResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentDetailRepository extends JpaRepository<RentDetail,Integer> {
    List<RentDetail> findByNameStartingWith(String name);

    List<GetListRentDetailResponse> findByNameDto(String name);

}
