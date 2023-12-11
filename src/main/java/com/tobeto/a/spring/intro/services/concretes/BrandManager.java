package com.tobeto.a.spring.intro.services.concretes;

import com.tobeto.a.spring.intro.entities.Brand;
import com.tobeto.a.spring.intro.repositories.BrandRepository;
import com.tobeto.a.spring.intro.services.abstracts.BrandService;
import com.tobeto.a.spring.intro.services.dtos.brand.requests.AddBrandRequest;
import com.tobeto.a.spring.intro.services.dtos.brand.requests.DeleteBrandRequest;
import com.tobeto.a.spring.intro.services.dtos.brand.requests.UpdateBrandRequest;
import com.tobeto.a.spring.intro.services.dtos.brand.responses.GetListBrandResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {

    private BrandRepository brandRepository;


    @Override
    public void add(AddBrandRequest request) {
        if (request.getName().length() < 3)
            throw new RuntimeException("Marka ismi 3 haneden küçük olamaz");

        if (brandRepository.existsBrandByName(request.getName())) {
            throw new RuntimeException("Bu Marka zaten mevcut.");
        }
        Brand brand = new Brand();
        brand.setName(request.getName());
        brandRepository.save(brand);
    }

    @Override
    public List<GetListBrandResponse> getByName(String name) {

        return brandRepository.findByName(name).stream().map((brand) -> {
            return new GetListBrandResponse(brand.getId(), brand.getName());
        }).toList();
    }

    @Override
    public List<GetListBrandResponse> getByNameDto(String name) {

        return brandRepository.findByName(name);
    }


    @Override
    public void update(UpdateBrandRequest request) {

        if (request.getName().length() < 3)
            throw new RuntimeException("Marka ismi 3 haneden küçük olamaz");
        if (brandRepository.existsBrandByName(request.getName())) {
            throw new RuntimeException("Bu Marka zaten mevcut.");
        }
        Brand brandToUpdate = brandRepository.findById(request.getId()).orElseThrow();

        brandToUpdate.setName(request.getName());
        brandRepository.save(brandToUpdate);
    }

    @Override
    public void delete(DeleteBrandRequest request) {
        Brand brandToDelete = brandRepository.findById(request.getId()).orElseThrow();
        brandRepository.delete(brandToDelete);
    }

    @Override
    public Brand getById(int id) {
        return brandRepository.findById(id).orElseThrow();
    }
}
