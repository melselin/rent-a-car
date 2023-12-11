package com.tobeto.a.spring.intro.services.dtos.address.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListAddressResponse {
    private int id;
    private String name;
}
