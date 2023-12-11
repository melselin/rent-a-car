package com.tobeto.a.spring.intro.repositories;

import com.tobeto.a.spring.intro.entities.Color;
import com.tobeto.a.spring.intro.services.dtos.color.responses.GetListColorResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ColorRepository extends JpaRepository<Color, Integer> {
    List<Color> findByNameStartingWith(String name);

    boolean existsColorByName(String name);

}
