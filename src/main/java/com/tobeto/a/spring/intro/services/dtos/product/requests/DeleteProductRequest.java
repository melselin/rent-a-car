package com.tobeto.a.spring.intro.services.dtos.product.requests;

import lombok.Data;

@Data
public class DeleteProductRequest {
    private String model;
    private String licencePlate;
    private int id;
}
