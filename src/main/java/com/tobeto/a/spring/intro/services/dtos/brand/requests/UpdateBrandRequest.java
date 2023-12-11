package com.tobeto.a.spring.intro.services.dtos.brand.requests;

import com.tobeto.a.spring.intro.entities.Brand;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBrandRequest {
    @Positive
    private int id;
    @NotBlank
    private String name;

}