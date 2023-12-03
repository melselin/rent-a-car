package com.tobeto.a.spring.intro.services.abstracts;

import com.tobeto.a.spring.intro.entities.Product;
import com.tobeto.a.spring.intro.services.dtos.product.requests.AddProductRequest;
import com.tobeto.a.spring.intro.services.dtos.product.requests.DeleteProductRequest;
import com.tobeto.a.spring.intro.services.dtos.product.requests.UpdateProductRequest;
import com.tobeto.a.spring.intro.services.dtos.product.responses.GetListProductResponse;

import java.util.List;

public interface ProductService {
    void add(AddProductRequest request);
    List<Product> getByModel(String model);
    List<GetListProductResponse> getByModelDto(String model);
    void update(UpdateProductRequest request);
    void delete(DeleteProductRequest request);
}
