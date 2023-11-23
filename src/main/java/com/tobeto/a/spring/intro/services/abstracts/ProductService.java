package com.tobeto.a.spring.intro.services.abstracts;

import com.tobeto.a.spring.intro.services.dtos.product.requests.AddProductRequest;
import com.tobeto.a.spring.intro.services.dtos.product.requests.DeleteProductRequest;
import com.tobeto.a.spring.intro.services.dtos.product.requests.UpdateProductRequest;

public interface ProductService {
    void add(AddProductRequest request);
    void update(UpdateProductRequest request);
    void delete(DeleteProductRequest request);
}
