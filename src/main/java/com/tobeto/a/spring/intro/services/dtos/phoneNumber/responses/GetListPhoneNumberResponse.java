package com.tobeto.a.spring.intro.services.dtos.phoneNumber.responses;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListPhoneNumberResponse {
    private int id;
    private String number;
}
