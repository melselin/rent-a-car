package com.tobeto.a.spring.intro.services.concretes;

import com.tobeto.a.spring.intro.entities.Brand;
import com.tobeto.a.spring.intro.entities.Customer;
import com.tobeto.a.spring.intro.entities.Identity;
import com.tobeto.a.spring.intro.repositories.IdentityRepository;
import com.tobeto.a.spring.intro.services.abstracts.IdentityService;
import com.tobeto.a.spring.intro.services.dtos.identity.requests.AddIdentityRequest;
import com.tobeto.a.spring.intro.services.dtos.identity.requests.DeleteIdentityRequest;
import com.tobeto.a.spring.intro.services.dtos.identity.requests.UpdateIdentityRequest;
import org.springframework.stereotype.Service;

@Service
public class IdentityManager implements IdentityService {

    private IdentityRepository identityRepository;

    public IdentityManager(IdentityRepository identityRepository) {
        this.identityRepository = identityRepository;
    }

    @Override
    public void add(AddIdentityRequest request) {
        Identity identity = new Identity();
        identity.setNationalIdOrPassportNum(request.getNationalIdOrPassportNumber());
        identity.setDriverLicenceNum(request.getDriverLicenceNumber());
        identityRepository.save(identity);

    }

    @Override
    public void update(UpdateIdentityRequest request) {
        Identity identityToUpdate = identityRepository.findById(request.getId()).orElseThrow();
        identityToUpdate.setDriverLicenceNum(request.getDriverLicenceNumber());
        identityToUpdate.setNationalIdOrPassportNum(request.getNationalIdOrPassportNumber());
        identityRepository.save(identityToUpdate);
    }

    @Override
    public void delete(DeleteIdentityRequest request) {
        Identity identityToDelete = identityRepository.findById(request.getId()).orElseThrow();
        identityRepository.delete(identityToDelete);
    }
}
