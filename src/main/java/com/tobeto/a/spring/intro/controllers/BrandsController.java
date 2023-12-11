package com.tobeto.a.spring.intro.controllers;
import com.tobeto.a.spring.intro.entities.Brand;
import com.tobeto.a.spring.intro.repositories.BrandRepository;
import com.tobeto.a.spring.intro.services.abstracts.BrandService;
import com.tobeto.a.spring.intro.services.dtos.brand.requests.AddBrandRequest;
import com.tobeto.a.spring.intro.services.dtos.brand.requests.DeleteBrandRequest;
import com.tobeto.a.spring.intro.services.dtos.brand.requests.UpdateBrandRequest;
import com.tobeto.a.spring.intro.services.dtos.brand.responses.GetListBrandResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Single Responsibility
@RestController
@AllArgsConstructor
@RequestMapping("api/brands")
public class BrandsController {
    // BAĞIMLILIKLAR DAİMA SOYUT NESNELER ÜZERİNDEN
    private final BrandService brandService;
    private final BrandRepository brandRepository;


    @PostMapping
    public void add(@RequestBody AddBrandRequest request){
        brandService.add(request);
    }
    @GetMapping
    public List<GetListBrandResponse> getByName(@RequestParam String name){
        return brandService.getByName(name);
    }
    @GetMapping("dto")
    public List<GetListBrandResponse> getByNameDto(@RequestParam String name){
        return brandService.getByNameDto(name);
    }
    
    @PutMapping
    public void update(@RequestBody UpdateBrandRequest request){
        brandService.update(request);
    }
    @DeleteMapping
    public void delete(@RequestBody DeleteBrandRequest request){
        brandService.delete(request);
    }
}