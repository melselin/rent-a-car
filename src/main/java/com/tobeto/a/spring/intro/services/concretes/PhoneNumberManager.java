package com.tobeto.a.spring.intro.services.concretes;

import com.tobeto.a.spring.intro.entities.PhoneNumber;
import com.tobeto.a.spring.intro.repositories.PhoneNumberRepository;
import com.tobeto.a.spring.intro.services.abstracts.PhoneNumberService;
import com.tobeto.a.spring.intro.services.dtos.phoneNumber.requests.AddPhoneNumberRequest;
import com.tobeto.a.spring.intro.services.dtos.phoneNumber.requests.DeletePhoneNumberRequest;
import com.tobeto.a.spring.intro.services.dtos.phoneNumber.requests.UpdatePhoneNumberRequest;
import org.springframework.stereotype.Service;

@Service
public class PhoneNumberManager implements PhoneNumberService {

    private PhoneNumberRepository phoneNumberRepository;

    public PhoneNumberManager(PhoneNumberRepository phoneNumberRepository) {
        this.phoneNumberRepository = phoneNumberRepository;
    }

    @Override
    public void add(AddPhoneNumberRequest request) {
        PhoneNumber phoneNumber = new PhoneNumber();
        phoneNumber.setPhoneNum(request.getNumber());
        phoneNumberRepository.save(phoneNumber);
    }

    @Override
    public void update(UpdatePhoneNumberRequest request) {
        PhoneNumber phoneNumberToUpdate = phoneNumberRepository.findById(request.getId()).orElseThrow();
        phoneNumberToUpdate.setPhoneNum(request.getNumber());
        phoneNumberRepository.save(phoneNumberToUpdate);

    }

    @Override
    public void delete(DeletePhoneNumberRequest request) {
        PhoneNumber phoneNumberToDelete = phoneNumberRepository.findById(request.getId()).orElseThrow();
        phoneNumberRepository.delete(phoneNumberToDelete);
    }
}
