package com.tobeto.a.spring.intro.services.dtos.phoneNumber.requests;

import lombok.Data;

@Data
public class UpdatePhoneNumberRequest {
    private String number;
    private int id;
}
