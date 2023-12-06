package com.tobeto.a.spring.intro.controllers;

import com.tobeto.a.spring.intro.entities.Customer;
import com.tobeto.a.spring.intro.repositories.CustomerRepository;
import com.tobeto.a.spring.intro.services.abstracts.CustomerService;
import com.tobeto.a.spring.intro.services.dtos.customer.requests.AddCustomerRequest;
import com.tobeto.a.spring.intro.services.dtos.customer.requests.DeleteCustomerRequest;
import com.tobeto.a.spring.intro.services.dtos.customer.requests.UpdateCustomerRequest;
import com.tobeto.a.spring.intro.services.dtos.customer.responses.GetListCustomerResponse;
import com.tobeto.a.spring.intro.services.dtos.product.requests.UpdateProductRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/customers")
public class CustomersController {
    private final CustomerService customerService;

    public CustomersController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public void add(@RequestBody AddCustomerRequest request) {
        customerService.add(request);
    }

/*    @GetMapping
    public List<Customer> getByName(@RequestParam String name){
        return customerService.getByName(name);
    }

    @GetMapping("dto")
    public  List<GetListCustomerResponse> getByNameDto(@RequestParam String name){
        return  customerService.getByNameDto(name);
    }*/
    @PutMapping
    public void update(@RequestBody UpdateCustomerRequest request) {
        customerService.update(request);
    }

    @DeleteMapping
    public void delete(@RequestBody DeleteCustomerRequest request) {
        customerService.delete(request);
    }


}
