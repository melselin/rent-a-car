package com.tobeto.a.spring.intro.controllers;

import com.tobeto.a.spring.intro.entities.Product;
import com.tobeto.a.spring.intro.repositories.ProductRepository;
import com.tobeto.a.spring.intro.services.abstracts.ProductService;
import com.tobeto.a.spring.intro.services.dtos.product.responses.GetListProductResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductsController {
    private ProductRepository productRepository;
    private ProductService productService;

    public ProductsController(ProductRepository productRepository, ProductService productService) {
        this.productRepository = productRepository;
        this.productService = productService;
    }

    @GetMapping()
    public List<Product> getByModel(@RequestParam String model) {
        return productService.getByModel(model);
    }

    @GetMapping("dto")
    public List<GetListProductResponse> getByModelDto(@RequestParam String model) {
        return productService.getByModelDto(model);
    }

    @GetMapping("{id}")
    public Product getById(@PathVariable int id) {
        return productRepository.findById(id).orElseThrow();
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

