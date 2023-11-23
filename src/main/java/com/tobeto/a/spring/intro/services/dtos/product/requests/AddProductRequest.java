package com.tobeto.a.spring.intro.services.dtos.product.requests;

import lombok.Data;

@Data
public class AddProductRequest {
    private String model;
    private String licencePlate;
}
