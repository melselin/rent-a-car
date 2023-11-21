package com.tobeto.a.spring.intro.repositories;

import com.tobeto.a.spring.intro.entities.Color;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColorRepository extends JpaRepository<Color, Integer> {
}
