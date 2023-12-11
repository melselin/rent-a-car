package com.tobeto.a.spring.intro.services.abstracts;

import com.tobeto.a.spring.intro.entities.Address;
import com.tobeto.a.spring.intro.services.dtos.address.requests.AddAddressRequest;
import com.tobeto.a.spring.intro.services.dtos.address.requests.DeleteAddressRequest;
import com.tobeto.a.spring.intro.services.dtos.address.requests.UpdateAddressRequest;
import com.tobeto.a.spring.intro.services.dtos.address.responses.GetListAddressResponse;

import java.util.List;

public interface AddressService {
    List<Address> findByName(String name);

    void add(AddAddressRequest request);
    void update(UpdateAddressRequest request);
    void delete(DeleteAddressRequest request);
    Address getById(int id);
}
