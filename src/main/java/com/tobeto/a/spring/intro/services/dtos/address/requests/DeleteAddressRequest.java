package com.tobeto.a.spring.intro.services.dtos.address.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteAddressRequest {
    @Positive
    private int id;
    @NotBlank
    private String name;
}
