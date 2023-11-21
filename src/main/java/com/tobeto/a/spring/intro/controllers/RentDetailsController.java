package com.tobeto.a.spring.intro.controllers;

import com.tobeto.a.spring.intro.entities.RentDetail;
import com.tobeto.a.spring.intro.repositories.RentDetailRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rentDetails")
public class RentDetailsController {
    private final RentDetailRepository rentDetailRepository;

    public RentDetailsController(RentDetailRepository rentDetailRepository) {
        this.rentDetailRepository = rentDetailRepository;
    }


    @GetMapping
    public List<RentDetail> getAll(){
        List<RentDetail> rentDetails = rentDetailRepository.findAll();
        return rentDetails;
    }

    @GetMapping("{id}")
    public RentDetail getById(@PathVariable int id){
        return rentDetailRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody RentDetail rentDetail){
        rentDetailRepository.save(rentDetail);
    }

    @DeleteMapping
    public void delete(@PathVariable int id){
        RentDetail rentDetailToDelete = rentDetailRepository.findById(id).orElseThrow();
        rentDetailRepository.delete(rentDetailToDelete);
    }

    @PutMapping
    public void update(@PathVariable int id, @RequestBody RentDetail rentDetail){
        RentDetail rentDetailToUpdate = rentDetailRepository.findById(id).orElseThrow();
        rentDetailToUpdate.setRentStartDate(rentDetail.getRentStartDate());
        rentDetailToUpdate.setRentEndDate(rentDetail.getRentEndDate());
        rentDetailToUpdate.setTotalRentDay(rentDetail.getTotalRentDay());
        rentDetailRepository.save(rentDetailToUpdate);

    }
}

