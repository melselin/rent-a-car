package com.tobeto.a.spring.intro.services.concretes;

import com.tobeto.a.spring.intro.entities.Brand;
import com.tobeto.a.spring.intro.entities.Car;
import com.tobeto.a.spring.intro.entities.Color;
import com.tobeto.a.spring.intro.repositories.CarRepository;
import com.tobeto.a.spring.intro.services.abstracts.BrandService;
import com.tobeto.a.spring.intro.services.abstracts.CarService;
import com.tobeto.a.spring.intro.services.abstracts.ColorService;
import com.tobeto.a.spring.intro.services.dtos.car.requests.AddCarRequest;
import com.tobeto.a.spring.intro.services.dtos.car.requests.DeleteCarRequest;
import com.tobeto.a.spring.intro.services.dtos.car.requests.UpdateCarRequest;
import com.tobeto.a.spring.intro.services.dtos.car.responses.GetListCarResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;

@AllArgsConstructor
@Service
public class CarManager implements CarService {

    private final CarRepository carRepository;
    private final BrandService brandService;
    private final ColorService colorService;


    @Override
    public List<Car> getAll() {
        return carRepository.findAll();
    }

    @Override
    public void add(AddCarRequest request) {
        if(carRepository.existsCarByLicencePlate(request.getLicencePlate()))
        {
            throw new RuntimeException("Aynı plaka ile 2. araç eklenemez.");
        }
        Car car = new Car();
        car.setModel(request.getModel());
        car.setLicencePlate(request.getLicencePlate());
        Brand brand = brandService.getById(request.getId());
        car.setBrand(brand);
        Color color = colorService.getById(request.getId());
        car.setColor(color);
        carRepository.save(car);
    }

    @Override
    public void update(UpdateCarRequest request) {
        if(carRepository.existsCarByLicencePlate(request.getLicencePlate()))
        {
            throw new RuntimeException("Bu plaka zaten kullanımda. Lütfen geçerli bir plaka giriniz.");
        }
        Car carToUpdate = carRepository.findById(request.getId()).orElseThrow();
        carToUpdate.setModel(request.getModel());
        carToUpdate.setLicencePlate(request.getLicencePlate());
        Brand brand = brandService.getById(request.getId());
        carToUpdate.setBrand(brand);
        Color color = colorService.getById(request.getId());
        carToUpdate.setColor(color);
        carRepository.save(carToUpdate);
    }

    @Override
    public void delete(DeleteCarRequest request) {
        Car carToDelete = carRepository.findById(request.getId()).orElseThrow();
        carRepository.delete(carToDelete);
    }

    @Override
    public Car getById(int id) {
        return carRepository.findById(id).orElseThrow();
    }

    @Override
    public List<GetListCarResponse> getAllDto() {
        return carRepository.getAllDto();
    }
}