package com.tobeto.a.spring.intro.controllers;

import com.tobeto.a.spring.intro.entities.Identity;
import com.tobeto.a.spring.intro.repositories.IdentityRepository;
import com.tobeto.a.spring.intro.services.abstracts.IdentityService;
import com.tobeto.a.spring.intro.services.dtos.identity.responses.GetListIdentityResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/identities")
public class IdentitiesController {

    private final IdentityRepository identityRepository;

    private final IdentityService identityService;

    public IdentitiesController(IdentityRepository identityRepository, IdentityService identityService) {
        this.identityRepository = identityRepository;
        this.identityService = identityService;
    }


    @GetMapping
    public List<GetListIdentityResponse> getByNationalId(@RequestParam String nationalId) {
        return identityService.getByNationalId(nationalId);
    }

    @GetMapping("dto")
    public List<GetListIdentityResponse> getByNationalIdDto(@RequestParam String nationalId) {
        return identityService.getByNationalIdDto(nationalId);
    }


    @GetMapping("{id}")
    public Identity getById(@PathVariable int id) {
        return identityRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Identity identity) {
        identityRepository.save(identity);
    }

    @DeleteMapping
    public void delete(@PathVariable int id) {
        Identity identityToDelete = identityRepository.findById(id).orElseThrow();
        identityRepository.delete(identityToDelete);
    }

    @PutMapping
    public void update(@PathVariable int id, @RequestBody Identity identity) {
        Identity identityToUpdate = identityRepository.findById(id).orElseThrow();
        //Optional to update below info since they dont change over time. So it can be deleted or stay.
        identityToUpdate.setNationalId(identity.getNationalId());
        identityToUpdate.setDriverLicenceNum(identity.getDriverLicenceNum());
        identityRepository.save(identityToUpdate);


    }
}