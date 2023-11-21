package com.tobeto.a.spring.intro.repositories;

import com.tobeto.a.spring.intro.entities.RentDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentDetailRepository extends JpaRepository<RentDetail,Integer> {
}
