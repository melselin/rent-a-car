package com.tobeto.a.spring.intro.services.dtos.car.requests;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCarRequest {
    @Positive
    private int id;
    @NotBlank
    private String model;
    @NotBlank
    private String licencePlate;
}
