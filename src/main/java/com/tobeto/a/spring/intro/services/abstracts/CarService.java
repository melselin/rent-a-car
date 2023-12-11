package com.tobeto.a.spring.intro.services.abstracts;

import com.tobeto.a.spring.intro.entities.Car;
import com.tobeto.a.spring.intro.services.dtos.car.requests.AddCarRequest;
import com.tobeto.a.spring.intro.services.dtos.car.requests.DeleteCarRequest;
import com.tobeto.a.spring.intro.services.dtos.car.requests.UpdateCarRequest;
import com.tobeto.a.spring.intro.services.dtos.car.responses.GetListCarResponse;

import java.util.List;

public interface CarService {
    List<GetListCarResponse> getAllDto();

    List<Car> getAll();

    void add(AddCarRequest request);

    void update(UpdateCarRequest request);

    void delete(DeleteCarRequest request);

    Car getById(int id);
}
