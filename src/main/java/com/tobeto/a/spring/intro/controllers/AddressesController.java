package com.tobeto.a.spring.intro.controllers;

import com.tobeto.a.spring.intro.entities.Address;
import com.tobeto.a.spring.intro.repositories.AddressRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/addresses")
public class AddressesController {

    private final AddressRepository addressRepository;

    public AddressesController(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @GetMapping
    public List<Address> getAll(){
        List<Address> Addresses = addressRepository.findAll();
        return Addresses;
    }

    @GetMapping("{id}")
    public Address getById(@PathVariable int id){
        return addressRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Address address){
        addressRepository.save(address);
    }

    @DeleteMapping
    public void delete(@PathVariable int id){
        Address addressToDelete = addressRepository.findById(id).orElseThrow();
        addressRepository.delete(addressToDelete);
    }

    @PutMapping
    public void update(@PathVariable int id, @RequestBody Address address){
        Address addressToUpdate = addressRepository.findById(id).orElseThrow();
        addressToUpdate.setAddress(address.getAddress());
        addressRepository.save(addressToUpdate);

    }
}
