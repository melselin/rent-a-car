package com.tobeto.a.spring.intro.services.abstracts;

import com.tobeto.a.spring.intro.entities.Customer;
import com.tobeto.a.spring.intro.services.dtos.customer.requests.AddCustomerRequest;
import com.tobeto.a.spring.intro.services.dtos.customer.requests.DeleteCustomerRequest;
import com.tobeto.a.spring.intro.services.dtos.customer.requests.UpdateCustomerRequest;
import com.tobeto.a.spring.intro.services.dtos.customer.responses.GetListCustomerResponse;

import java.util.List;

public interface CustomerService {
    void add(AddCustomerRequest request);

    void update(UpdateCustomerRequest request);

    void delete(DeleteCustomerRequest request);


    List<Customer> getByNameStartingWith(String name);
    List<GetListCustomerResponse> getByName(String name);
    List<GetListCustomerResponse> getByNameDto(String name);

    Customer getById(int id);
}
