package com.tobeto.a.spring.intro.services.dtos.phoneNumber.requests;

import lombok.Data;

@Data
public class DeletePhoneNumberRequest {
    private String number;
    private int id;
}
