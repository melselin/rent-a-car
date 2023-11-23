package com.tobeto.a.spring.intro.services.dtos.identity.requests;

import lombok.Data;

@Data
public class UpdateIdentityRequest {
    private String nationalIdOrPassportNumber;
    private String driverLicenceNumber;
    private int id;
}
