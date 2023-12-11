package com.tobeto.a.spring.intro.controllers;

import com.tobeto.a.spring.intro.entities.RentDetail;
import com.tobeto.a.spring.intro.repositories.RentDetailRepository;
import com.tobeto.a.spring.intro.services.abstracts.RentDetailService;
import com.tobeto.a.spring.intro.services.dtos.rentDetail.requests.AddRentDetailRequest;
import com.tobeto.a.spring.intro.services.dtos.rentDetail.requests.DeleteRentDetailRequest;
import com.tobeto.a.spring.intro.services.dtos.rentDetail.requests.UpdateRentDetailRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("rentDetails")
public class RentDetailsController {
    private final RentDetailRepository rentDetailRepository;
    private final RentDetailService rentDetailService;


    @GetMapping
    public List<RentDetail> getAll() {
        List<RentDetail> rentDetails = rentDetailRepository.findAll();
        return rentDetails;
    }

    @GetMapping("{id}")
    public RentDetail getById(@PathVariable int id) {
        return rentDetailRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody @Valid AddRentDetailRequest request) {
        rentDetailService.add(request);
    }

    @DeleteMapping
    public void delete(@PathVariable DeleteRentDetailRequest request) {
        rentDetailService.delete(request);
    }

    @PutMapping
    public void update(@PathVariable int id, @RequestBody @Valid UpdateRentDetailRequest request) {
        rentDetailService.update(request);

    }
}

