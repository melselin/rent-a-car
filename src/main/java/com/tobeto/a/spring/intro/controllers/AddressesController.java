package com.tobeto.a.spring.intro.controllers;

import com.tobeto.a.spring.intro.entities.Address;
import com.tobeto.a.spring.intro.repositories.AddressRepository;
import com.tobeto.a.spring.intro.services.abstracts.AddressService;
import com.tobeto.a.spring.intro.services.dtos.address.requests.AddAddressRequest;
import com.tobeto.a.spring.intro.services.dtos.address.requests.DeleteAddressRequest;
import com.tobeto.a.spring.intro.services.dtos.address.requests.UpdateAddressRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/addresses")
public class AddressesController {

    private final AddressRepository addressRepository;
    private AddressService addressService;

    @GetMapping
    public List<Address> getAll() {
        List<Address> Addresses = addressRepository.findAll();
        return Addresses;
    }

    @GetMapping("{id}")
    public Address getById(@PathVariable int id) {
        return addressRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody @Valid AddAddressRequest request) {
        addressService.add(request);

    }

    @DeleteMapping
    public void delete(@PathVariable DeleteAddressRequest request) {
        addressService.delete(request);
    }

    @PutMapping
    public void update(@PathVariable int id, @RequestBody @Valid UpdateAddressRequest request) {
        addressService.update(request);

    }
}
