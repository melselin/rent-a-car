package com.tobeto.a.spring.intro.services.dtos.customer.requests;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCustomerRequest {
    @Positive
    private int id;
    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    @Min(value = 18, message = "18'den büyük bir yaş giriniz.")
    private int age;
}
