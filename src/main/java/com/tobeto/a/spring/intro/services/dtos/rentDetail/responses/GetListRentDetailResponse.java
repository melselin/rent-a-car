package com.tobeto.a.spring.intro.services.dtos.rentDetail.responses;

import com.tobeto.a.spring.intro.services.dtos.car.responses.GetListCarResponse;
import com.tobeto.a.spring.intro.services.dtos.customer.responses.GetListCustomerResponse;
import com.tobeto.a.spring.intro.services.dtos.employee.responses.GetListEmployeeResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListRentDetailResponse {
    private int id;
    private int totalRentDay;
    private LocalDate rentStartDate;
    private LocalDate rentEndDate;
    private GetListCarResponse car;
    private GetListCustomerResponse customer;
    private GetListEmployeeResponse employee;
}
