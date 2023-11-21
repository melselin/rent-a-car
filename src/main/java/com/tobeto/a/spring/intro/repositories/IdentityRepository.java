package com.tobeto.a.spring.intro.repositories;

import com.tobeto.a.spring.intro.entities.Identity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IdentityRepository extends JpaRepository<Identity,Integer> {
}
