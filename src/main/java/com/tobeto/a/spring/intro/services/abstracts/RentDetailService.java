package com.tobeto.a.spring.intro.services.abstracts;

import com.tobeto.a.spring.intro.entities.RentDetail;
import com.tobeto.a.spring.intro.services.dtos.rentDetail.requests.AddRentDetailRequest;
import com.tobeto.a.spring.intro.services.dtos.rentDetail.requests.DeleteRentDetailRequest;
import com.tobeto.a.spring.intro.services.dtos.rentDetail.requests.UpdateRentDetailRequest;

import java.util.List;

public interface RentDetailService {
    List<RentDetail> getAll();
    void add(AddRentDetailRequest request);
    void update(UpdateRentDetailRequest request);
    void delete(DeleteRentDetailRequest request);
}
