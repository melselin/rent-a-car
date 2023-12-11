package com.tobeto.a.spring.intro.services.concretes;

import com.tobeto.a.spring.intro.entities.Address;
import com.tobeto.a.spring.intro.entities.Brand;
import com.tobeto.a.spring.intro.entities.Customer;
import com.tobeto.a.spring.intro.repositories.CustomerRepository;
import com.tobeto.a.spring.intro.services.abstracts.AddressService;
import com.tobeto.a.spring.intro.services.abstracts.CustomerService;
import com.tobeto.a.spring.intro.services.dtos.customer.requests.AddCustomerRequest;
import com.tobeto.a.spring.intro.services.dtos.customer.requests.DeleteCustomerRequest;
import com.tobeto.a.spring.intro.services.dtos.customer.requests.UpdateCustomerRequest;
import com.tobeto.a.spring.intro.services.dtos.customer.responses.GetListCustomerResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService {

    private final CustomerRepository customerRepository;
    private final AddressService addressService;

    @Override
    public void add(AddCustomerRequest request) {
        if(customerRepository.existsCustomerByName(request.getName())&& customerRepository.existsCustomerBySurname(request.getSurname())){
            throw new RuntimeException("Bu kullanıcı zaten mevcut");
        }
        Customer customer = new Customer();
        customer.setName(request.getName());
        customer.setSurname(request.getSurname());
        Address address = addressService.getById(request.getId());
        customer.setAddress(address);
        customerRepository.save(customer);

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
    public Customer getById(int id) {
        return customerRepository.findById(id).orElseThrow();
    }
}
