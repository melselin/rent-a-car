package com.tobeto.a.spring.intro.services.concretes;

import com.tobeto.a.spring.intro.entities.Brand;
import com.tobeto.a.spring.intro.repositories.BrandRepository;
import com.tobeto.a.spring.intro.services.abstracts.BrandService;
import com.tobeto.a.spring.intro.services.dtos.brand.requests.AddBrandRequest;
import com.tobeto.a.spring.intro.services.dtos.brand.requests.DeleteBrandRequest;
import com.tobeto.a.spring.intro.services.dtos.brand.requests.UpdateBrandRequest;
import org.springframework.stereotype.Service;

@Service
public class BrandManager implements BrandService {

    private BrandRepository brandRepository;

    public BrandManager(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }


    @Override
    public void add(AddBrandRequest request) {
        // iş akışı çalıştıktan sonra..
        if(request.getName().length() < 3)
            throw new RuntimeException("Marka ismi 3 haneden küçük olamaz");

        Brand brand = new Brand();
        brand.setName(request.getName());
        brandRepository.save(brand);
    }

    @Override
    public void update(UpdateBrandRequest request) {
        Brand brandToUpdate = brandRepository.findById(request.getId()).orElseThrow();

        brandToUpdate.setName(request.getName());
        brandRepository.save(brandToUpdate);
    }

    @Override
    public void delete(DeleteBrandRequest request) {
        Brand brandToDelete = brandRepository.findById(request.getId()).orElseThrow();
        brandRepository.delete(brandToDelete);
    }
}
