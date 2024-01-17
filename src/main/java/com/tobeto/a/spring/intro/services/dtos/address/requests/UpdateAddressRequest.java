package com.tobeto.a.spring.intro.services.dtos.address.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAddressRequest {
    @Positive
    private int id;
    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    @Size(min=18)
    private int age;
    @NotBlank
    private String email;
    @NotBlank
    private String password;


}
