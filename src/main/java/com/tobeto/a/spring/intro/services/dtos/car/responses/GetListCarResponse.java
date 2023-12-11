package com.tobeto.a.spring.intro.services.dtos.car.responses;
import com.tobeto.a.spring.intro.services.dtos.brand.responses.GetListBrandResponse;
import com.tobeto.a.spring.intro.services.dtos.color.responses.GetListColorResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListCarResponse {
    private int id;
    private String model;
    private double dailyPrice;
    private String description;
    private String licencePlate;
    private GetListBrandResponse brand;
    private GetListColorResponse color;
}
