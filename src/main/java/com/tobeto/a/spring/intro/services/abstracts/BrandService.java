package com.tobeto.a.spring.intro.services.abstracts;

import com.tobeto.a.spring.intro.services.dtos.brand.requests.AddBrandRequest;
import com.tobeto.a.spring.intro.services.dtos.brand.requests.DeleteBrandRequest;
import com.tobeto.a.spring.intro.services.dtos.brand.requests.UpdateBrandRequest;

public interface BrandService {
    void add(AddBrandRequest request);
    void update(UpdateBrandRequest request);
    void delete(DeleteBrandRequest request);
}