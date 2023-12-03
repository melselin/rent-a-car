package com.tobeto.a.spring.intro.services.dtos.identity.requests;

import lombok.Data;

@Data
public class AddIdentityRequest {
    private String nationalId;
    private String driverLicenceNumber;
}
