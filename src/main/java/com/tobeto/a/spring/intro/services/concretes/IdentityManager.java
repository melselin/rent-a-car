package com.tobeto.a.spring.intro.services.concretes;

import com.tobeto.a.spring.intro.entities.Identity;
import com.tobeto.a.spring.intro.repositories.IdentityRepository;
import com.tobeto.a.spring.intro.services.abstracts.IdentityService;
import com.tobeto.a.spring.intro.services.dtos.identity.requests.AddIdentityRequest;
import com.tobeto.a.spring.intro.services.dtos.identity.requests.DeleteIdentityRequest;
import com.tobeto.a.spring.intro.services.dtos.identity.requests.UpdateIdentityRequest;
import com.tobeto.a.spring.intro.services.dtos.identity.responses.GetListIdentityResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IdentityManager implements IdentityService {

    private IdentityRepository identityRepository;

    public IdentityManager(IdentityRepository identityRepository) {
        this.identityRepository = identityRepository;
    }

    @Override
    public void add(AddIdentityRequest request) {
        Identity identity = new Identity();
        identity.setNationalId(request.getNationalId());
        identity.setDriverLicenceNum(request.getDriverLicenceNumber());
        identityRepository.save(identity);

    }

    @Override
    public List<Identity> getByNationalId(String nationalId) {
        return identityRepository.findByNationalIdStartingWith(nationalId);
    }

    @Override
    public List<GetListIdentityResponse> getByNationalIdDto(String nationalId) {
        return identityRepository.findByNationalId(nationalId);
    }


    @Override
    public void update(UpdateIdentityRequest request) {
        Identity identityToUpdate = identityRepository.findById(request.getId()).orElseThrow();
        identityToUpdate.setDriverLicenceNum(request.getDriverLicenceNumber());
        identityToUpdate.setNationalId(request.getNationalId());
        identityRepository.save(identityToUpdate);
    }

    @Override
    public void delete(DeleteIdentityRequest request) {
        Identity identityToDelete = identityRepository.findById(request.getId()).orElseThrow();
        identityRepository.delete(identityToDelete);
    }
}
