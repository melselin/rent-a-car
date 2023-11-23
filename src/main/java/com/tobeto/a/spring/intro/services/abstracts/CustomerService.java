package com.tobeto.a.spring.intro.services.abstracts;

import com.tobeto.a.spring.intro.services.dtos.customer.requests.AddCustomerRequest;
import com.tobeto.a.spring.intro.services.dtos.customer.requests.DeleteCustomerRequest;
import com.tobeto.a.spring.intro.services.dtos.customer.requests.UpdateCustomerRequest;

public interface CustomerService {
    void add(AddCustomerRequest request);
    void update(UpdateCustomerRequest request);
    void delete(DeleteCustomerRequest request);
}
