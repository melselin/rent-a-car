package com.tobeto.a.spring.intro.services.concretes;

import com.tobeto.a.spring.intro.entities.Product;
import com.tobeto.a.spring.intro.repositories.ProductRepository;
import com.tobeto.a.spring.intro.services.abstracts.ProductService;
import com.tobeto.a.spring.intro.services.dtos.product.requests.AddProductRequest;
import com.tobeto.a.spring.intro.services.dtos.product.requests.DeleteProductRequest;
import com.tobeto.a.spring.intro.services.dtos.product.requests.UpdateProductRequest;
import org.springframework.stereotype.Service;

@Service
public class ProductManager implements ProductService {

    private ProductRepository productRepository;

    public ProductManager(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void add(AddProductRequest request) {
        Product product = new Product();
        product.setModel(request.getModel());
        product.setLicencePlate(request.getLicencePlate());
        productRepository.save(product);
    }

    @Override
    public void update(UpdateProductRequest request) {
        Product productToUpdate = productRepository.findById(request.getId()).orElseThrow();
        productToUpdate.setLicencePlate(request.getLicencePlate());
        productRepository.save(productToUpdate);
    }

    @Override
    public void delete(DeleteProductRequest request) {
        Product productToDelete = productRepository.findById(request.getId()).orElseThrow();
        productRepository.delete(productToDelete);
    }
}
