package com.tobeto.a.spring.intro.controllers;

import com.tobeto.a.spring.intro.entities.Car;
import com.tobeto.a.spring.intro.repositories.CarRepository;
import com.tobeto.a.spring.intro.services.abstracts.CarService;
import com.tobeto.a.spring.intro.services.dtos.car.requests.AddCarRequest;
import com.tobeto.a.spring.intro.services.dtos.car.requests.DeleteCarRequest;
import com.tobeto.a.spring.intro.services.dtos.car.requests.UpdateCarRequest;
import com.tobeto.a.spring.intro.services.dtos.car.responses.GetListCarResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping("cars")
public class CarsController {
    private final CarService carService;

    @GetMapping
    public List<Car> getAll(){
        return carService.getAll();
    }

    @GetMapping("Dto")
    public List<GetListCarResponse> getAllDto(){
        return carService.getAllDto();
    }


    @PostMapping
    public void add(@RequestBody @Valid AddCarRequest request) {
        carService.add(request);
    }

    @DeleteMapping
    public void delete(@PathVariable DeleteCarRequest request) { carService.delete(request);
    }

    @PutMapping
    public void update(@PathVariable int id, @RequestBody @Valid UpdateCarRequest request) { carService.update(request);

    }
}

