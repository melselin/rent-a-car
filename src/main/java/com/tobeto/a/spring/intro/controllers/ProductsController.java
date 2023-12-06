package com.tobeto.a.spring.intro.controllers;

import com.tobeto.a.spring.intro.entities.Product;
import com.tobeto.a.spring.intro.repositories.ProductRepository;
import com.tobeto.a.spring.intro.services.abstracts.ProductService;
import com.tobeto.a.spring.intro.services.dtos.brand.responses.GetListBrandResponse;
import com.tobeto.a.spring.intro.services.dtos.product.responses.GetListProductResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductsController {
    private final ProductRepository productRepository;
    private final ProductService productService;

    public ProductsController(ProductRepository productRepository, ProductService productService) {
        this.productRepository = productRepository;
        this.productService = productService;
    }


    @GetMapping
    public List<GetListProductResponse> getAll(){
        return productService.getAll();
    }


    @PostMapping
    public void add(@RequestBody Product product) {
        productRepository.save(product);
    }

    @DeleteMapping
    public void delete(@PathVariable int id) {
        Product productToDelete = productRepository.findById(id).orElseThrow();
        productRepository.delete(productToDelete);
    }

    @PutMapping
    public void update(@PathVariable int id, @RequestBody Product product) {
        Product productToUpdate = productRepository.findById(id).orElseThrow();
        productToUpdate.setDailyPrice(product.getDailyPrice());
        productToUpdate.setDescription(product.getDescription());
        productToUpdate.setLicencePlate(product.getLicencePlate());
        productToUpdate.setModel(product.getModel());
        productRepository.save(productToUpdate);

    }
}

