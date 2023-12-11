package com.tobeto.a.spring.intro.services.concretes;

import com.tobeto.a.spring.intro.entities.Address;
import com.tobeto.a.spring.intro.repositories.AddressRepository;
import com.tobeto.a.spring.intro.services.abstracts.AddressService;
import com.tobeto.a.spring.intro.services.dtos.address.requests.AddAddressRequest;
import com.tobeto.a.spring.intro.services.dtos.address.requests.DeleteAddressRequest;
import com.tobeto.a.spring.intro.services.dtos.address.requests.UpdateAddressRequest;
import com.tobeto.a.spring.intro.services.dtos.address.responses.GetListAddressResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class AddressManager implements AddressService {
    private final AddressRepository addressRepository;


    @Override
    public List<Address> findByName(String name) {
        return addressRepository.findAll();
    }

    @Override
    public void add(AddAddressRequest request) {
        if(request.getName().length() < 1){
            throw new RuntimeException("Adres alanı boş bırakılamaz.");}
        Address address = new Address();
        address.setId(request.getId());
        address.setName(request.getName());

    }

    @Override
    public void update(UpdateAddressRequest request) {
        if(request.getName().length() < 1){
            throw new RuntimeException("Adres alanı boş bırakılamaz.");}
        Address addressToUpdate = addressRepository.findById(request.getId()).orElseThrow();
        addressToUpdate.setName(request.getName());
        addressRepository.save(addressToUpdate);

    }

    @Override
    public void delete(DeleteAddressRequest request) {
        Address addressToDelete = addressRepository.findById(request.getId()).orElseThrow();
        addressRepository.delete(addressToDelete);

    }

    @Override
    public Address getById(int id) {
        return addressRepository.findById(id).orElseThrow();
    }
}
