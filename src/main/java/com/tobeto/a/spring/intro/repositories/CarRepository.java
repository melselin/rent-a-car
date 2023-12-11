package com.tobeto.a.spring.intro.repositories;

import com.tobeto.a.spring.intro.entities.Car;
import com.tobeto.a.spring.intro.services.dtos.car.responses.GetListCarResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepository extends JpaRepository<Car,Integer> {



  @Query("Select new com.tobeto.a.spring.intro.services.dtos.car.responses.GetListCarResponse" +
            "(c.id, c.model, c.dailyPrice, c.description, c.licencePlate, " +
            "new com.tobeto.a.spring.intro.services.dtos.brand.responses.GetListBrandResponse" +
            "(b.id, b.name), new com.tobeto.a.spring.intro.services.dtos.color.responses.GetListColorResponse(co.id, co.name))" +
            " FROM Car c INNER JOIN c.brand b INNER JOIN c.color co ORDER BY c.model ASC")
    List<GetListCarResponse> getAllDto();
    boolean existsCarByLicencePlate(String licencePlate);


}
