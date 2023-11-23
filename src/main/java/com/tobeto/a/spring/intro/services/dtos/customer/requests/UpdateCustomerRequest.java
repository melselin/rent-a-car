package com.tobeto.a.spring.intro.services.dtos.customer.requests;

import lombok.Data;

@Data
public class UpdateCustomerRequest {
    private String name;
    private String surname;
    private int age;
    private int id;
}
