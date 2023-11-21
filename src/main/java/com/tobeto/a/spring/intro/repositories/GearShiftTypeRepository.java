package com.tobeto.a.spring.intro.repositories;

import com.tobeto.a.spring.intro.entities.GearShiftType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GearShiftTypeRepository extends JpaRepository<GearShiftType,Integer> {
}
