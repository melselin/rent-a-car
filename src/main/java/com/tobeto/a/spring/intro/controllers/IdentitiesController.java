package com.tobeto.a.spring.intro.controllers;

import com.tobeto.a.spring.intro.entities.Identity;
import com.tobeto.a.spring.intro.repositories.GearShiftTypeRepository;
import com.tobeto.a.spring.intro.repositories.IdentityRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/identities")
public class IdentitiesController {

    private final IdentityRepository identityRepository;

    public IdentitiesController(IdentityRepository identityRepository) {
        this.identityRepository = identityRepository;
    }


    @GetMapping
    public List<Identity> getAll(){
        List<Identity> identities = identityRepository.findAll();
        return identities;
    }

    @GetMapping("{id}")
    public Identity getById(@PathVariable int id){
        return identityRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Identity identity){
        identityRepository.save(identity);
    }

    @DeleteMapping
    public void delete(@PathVariable int id){
        Identity identityToDelete = identityRepository.findById(id).orElseThrow();
        identityRepository.delete(identityToDelete);
    }

    @PutMapping
    public void update(@PathVariable int id, @RequestBody Identity identity){
        Identity identityToUpdate = identityRepository.findById(id).orElseThrow();
        //Optional to update below info since they dont change over time. So it can be deleted or stay.
        identityToUpdate.setNationalIdOrPassportNum(identity.getNationalIdOrPassportNum());
        identityToUpdate.setDriverLicenceNum(identity.getDriverLicenceNum());
        identityRepository.save(identityToUpdate);



    }
}

