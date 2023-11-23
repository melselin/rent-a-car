package com.tobeto.a.spring.intro.services.dtos.brand.requests;

import com.tobeto.a.spring.intro.entities.Brand;
import lombok.Data;

@Data
public class DeleteBrandRequest {
    private String name;
    private int id;

}
