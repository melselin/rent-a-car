package com.tobeto.a.spring.intro.services.dtos.product.responses;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListProductResponse {
    private int id;
    private String model;
    private double dailyPrice;
    private String description;
    private String licencePlate;
}
