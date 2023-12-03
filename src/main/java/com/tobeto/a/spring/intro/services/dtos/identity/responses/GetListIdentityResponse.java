package com.tobeto.a.spring.intro.services.dtos.identity.responses;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListIdentityResponse {
    private int id;
    private String nationalId;
    private  String driverLicenceNum;

}
