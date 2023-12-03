package com.tobeto.a.spring.intro.controllers;

import com.tobeto.a.spring.intro.entities.PhoneNumber;
import com.tobeto.a.spring.intro.repositories.PhoneNumberRepository;
import com.tobeto.a.spring.intro.services.abstracts.PhoneNumberService;
import com.tobeto.a.spring.intro.services.dtos.phoneNumber.responses.GetListPhoneNumberResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("phoneNumbers")
public class PhoneNumbersController {
    private PhoneNumberRepository phoneNumberRepository;
    private PhoneNumberService phoneNumberService;

    public PhoneNumbersController(PhoneNumberRepository phoneNumberRepository, PhoneNumberService phoneNumberService) {
        this.phoneNumberRepository = phoneNumberRepository;
        this.phoneNumberService = phoneNumberService;
    }


    @GetMapping()
    public List<PhoneNumber> getByNumber(@RequestParam String number){
        return phoneNumberService.getByNumber(number);
    }

    @GetMapping("dto")
    public List<GetListPhoneNumberResponse> getByNumberDto(@RequestParam String number){
        return phoneNumberService.getByNumberDto(number);
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
        phoneNumberToUpdate.setNumber(phoneNumber.getNumber());
        phoneNumberRepository.save(phoneNumberToUpdate);

    }
}
