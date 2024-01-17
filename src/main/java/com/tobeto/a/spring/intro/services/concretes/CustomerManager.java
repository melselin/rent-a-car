package com.tobeto.a.spring.intro.services.concretes;

import com.tobeto.a.spring.intro.core.utilities.mappers.ModelMapperService;
import com.tobeto.a.spring.intro.entities.Address;
import com.tobeto.a.spring.intro.entities.Customer;
import com.tobeto.a.spring.intro.repositories.CustomerRepository;
import com.tobeto.a.spring.intro.services.abstracts.AddressService;
import com.tobeto.a.spring.intro.services.abstracts.CustomerService;
import com.tobeto.a.spring.intro.services.dtos.customer.requests.AddCustomerRequest;
import com.tobeto.a.spring.intro.services.dtos.customer.requests.DeleteCustomerRequest;
import com.tobeto.a.spring.intro.services.dtos.customer.requests.UpdateCustomerRequest;
import com.tobeto.a.spring.intro.services.dtos.customer.responses.GetByIdCustomerResponse;
import com.tobeto.a.spring.intro.services.dtos.customer.responses.GetListCustomerResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService {

    private final CustomerRepository customerRepository;
    private final AddressService addressService;

    private final ModelMapperService modelMapperService;

    @Override
    public void add(AddCustomerRequest request) {
        if(customerRepository.existsCustomerByName(request.getName())&& customerRepository.existsCustomerBySurname(request.getSurname())){
            throw new RuntimeException("Bu kullanıcı zaten mevcut");
        }
        Customer customer = this.modelMapperService.forRequest().map(request,Customer.class);
        this.customerRepository.save(customer);

    }

    @Override
    public void update(UpdateCustomerRequest request) {
        if(customerRepository.existsCustomerByName(request.getName())&& customerRepository.existsCustomerBySurname(request.getSurname())){
            throw new RuntimeException("Bu kullanıcı zaten mevcut");
        }
        Customer customerToUpdate = customerRepository.findById(request.getId()).orElseThrow();
        customerToUpdate.setName(request.getName());
        customerToUpdate.setSurname(request.getSurname());
        Address address = addressService.getById(request.getId());
        customerToUpdate.setAddress(address);
        customerRepository.save(customerToUpdate);

    }

    @Override
    public void delete(DeleteCustomerRequest request) {
        Customer customerToDelete = customerRepository.findById(request.getId()).orElseThrow();
        customerRepository.delete(customerToDelete);

    }


    @Override
    public List<Customer> getByNameStartingWith(String name) {
        return customerRepository.findByNameStartingWith(name);
    }

    @Override
    public List<GetListCustomerResponse> getByName(String name) {
        return customerRepository.findByName(name);
    }

    @Override
    public List<GetListCustomerResponse> getByNameDto(String name) {
        return customerRepository.findByName(name);
    }


    @Override
    public GetByIdCustomerResponse getById(int id) {
        Customer customer = customerRepository.findById(id).orElseThrow();
        GetByIdCustomerResponse response = this.modelMapperService.forResponse().map(customer, GetByIdCustomerResponse.class);
        return response;
    }

    @Override
    public GetByIdCustomerResponse getByEmail(String email){
        Customer customer = customerRepository.findByEmail(email).orElseThrow();
        GetByIdCustomerResponse response = this.modelMapperService.forResponse().map(customer, GetByIdCustomerResponse.class);
        return response;
    }

    @Override
    public List<Customer> getByAgeIsNull() {
        return customerRepository.findByAgeIsNull();
    }

    @Override
    public List<GetListCustomerResponse> findCustomerByAge(int age) {
        return customerRepository.findCustomerByAge(age).stream().map((customer) ->
                new GetListCustomerResponse()).toList();
    }
}
