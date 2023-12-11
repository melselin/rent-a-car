package com.tobeto.a.spring.intro.services.dtos.rentDetail.requests;

import com.tobeto.a.spring.intro.services.dtos.car.responses.GetListCarResponse;
import com.tobeto.a.spring.intro.services.dtos.customer.responses.GetListCustomerResponse;
import com.tobeto.a.spring.intro.services.dtos.employee.responses.GetListEmployeeResponse;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddRentDetailRequest {
    @Positive
    private int id;
    @Positive
    private int totalRentDay;
    @NotNull(message = "Lütfen yyyy-MM-dd şeklinde tarih giriniz ")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate rentStartDate;
    @NotNull(message = "Lütfen yyyy-MM-dd şeklinde tarih giriniz ")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Future
    private LocalDate rentEndDate;

}
