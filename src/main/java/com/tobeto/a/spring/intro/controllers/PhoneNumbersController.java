package com.tobeto.a.spring.intro.controllers;

import com.tobeto.a.spring.intro.entities.PhoneNumber;
import com.tobeto.a.spring.intro.repositories.PhoneNumberRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("phoneNumbers")
public class PhoneNumbersController {
    private final PhoneNumberRepository phoneNumberRepository;

    public PhoneNumbersController(PhoneNumberRepository phoneNumberRepository) {
        this.phoneNumberRepository = phoneNumberRepository;
    }


    @GetMapping
    public List<PhoneNumber> getAll(){
        List<PhoneNumber> phoneNumbers = phoneNumberRepository.findAll();
        return phoneNumbers;
    }

    @GetMapping("{id}")
    public PhoneNumber getById(@PathVariable int id){
        return phoneNumberRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody PhoneNumber phoneNumber){
        phoneNumberRepository.save(phoneNumber);
    }

    @DeleteMapping
    public void delete(@PathVariable int id){
        PhoneNumber phoneNumberToDelete = phoneNumberRepository.findById(id).orElseThrow();
        phoneNumberRepository.delete(phoneNumberToDelete);
    }

    @PutMapping
    public void update(@PathVariable int id, @RequestBody PhoneNumber phoneNumber){
        PhoneNumber phoneNumberToUpdate = phoneNumberRepository.findById(id).orElseThrow();
        phoneNumberToUpdate.setPhoneNum(phoneNumber.getPhoneNum());
        phoneNumberRepository.save(phoneNumberToUpdate);

    }
}
