package com.tobeto.a.spring.intro.services.abstracts;

import com.tobeto.a.spring.intro.entities.Brand;
import com.tobeto.a.spring.intro.services.dtos.brand.requests.AddBrandRequest;
import com.tobeto.a.spring.intro.services.dtos.brand.requests.DeleteBrandRequest;
import com.tobeto.a.spring.intro.services.dtos.brand.requests.UpdateBrandRequest;
import com.tobeto.a.spring.intro.services.dtos.brand.responses.GetListBrandResponse;

import java.util.List;

public interface BrandService {
    void add(AddBrandRequest request);

    List<GetListBrandResponse> getByName(String name);

    List<GetListBrandResponse> getByNameDto(String name);


    void update(UpdateBrandRequest request);

    void delete(DeleteBrandRequest request);

    Brand getById(int id);
}