package com.tobeto.a.spring.intro.services.concretes;

import com.tobeto.a.spring.intro.entities.PhoneNumber;
import com.tobeto.a.spring.intro.repositories.PhoneNumberRepository;
import com.tobeto.a.spring.intro.services.abstracts.PhoneNumberService;
import com.tobeto.a.spring.intro.services.dtos.phoneNumber.requests.AddPhoneNumberRequest;
import com.tobeto.a.spring.intro.services.dtos.phoneNumber.requests.DeletePhoneNumberRequest;
import com.tobeto.a.spring.intro.services.dtos.phoneNumber.requests.UpdatePhoneNumberRequest;
import com.tobeto.a.spring.intro.services.dtos.phoneNumber.responses.GetListPhoneNumberResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneNumberManager implements PhoneNumberService {

    private PhoneNumberRepository phoneNumberRepository;

    public PhoneNumberManager(PhoneNumberRepository phoneNumberRepository) {
        this.phoneNumberRepository = phoneNumberRepository;
    }

    @Override
    public void add(AddPhoneNumberRequest request) {
        PhoneNumber phoneNumber = new PhoneNumber();
        phoneNumber.setNumber(request.getNumber());
        phoneNumberRepository.save(phoneNumber);
    }

    @Override
    public List<GetListPhoneNumberResponse> getByNumber(String number) {
        return phoneNumberRepository.findByNumberStartingWith(number).stream().map((phoneNumber) -> {
            return new GetListPhoneNumberResponse(phoneNumber.getId(), phoneNumber.getNumber());
        }).toList();
    }

        @Override
        public List<GetListPhoneNumberResponse> getByNumberDto (String number){
            return phoneNumberRepository.findByNumber(number);
        }

        @Override
        public void update (UpdatePhoneNumberRequest request){
            PhoneNumber phoneNumberToUpdate = phoneNumberRepository.findById(request.getId()).orElseThrow();
            phoneNumberToUpdate.setNumber(request.getNumber());
            phoneNumberRepository.save(phoneNumberToUpdate);

        }

        @Override
        public void delete (DeletePhoneNumberRequest request){
            PhoneNumber phoneNumberToDelete = phoneNumberRepository.findById(request.getId()).orElseThrow();
            phoneNumberRepository.delete(phoneNumberToDelete);
        }
    }
