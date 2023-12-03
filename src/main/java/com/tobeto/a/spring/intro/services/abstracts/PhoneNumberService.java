package com.tobeto.a.spring.intro.services.abstracts;

import com.tobeto.a.spring.intro.entities.PhoneNumber;
import com.tobeto.a.spring.intro.services.dtos.phoneNumber.requests.AddPhoneNumberRequest;
import com.tobeto.a.spring.intro.services.dtos.phoneNumber.requests.DeletePhoneNumberRequest;
import com.tobeto.a.spring.intro.services.dtos.phoneNumber.requests.UpdatePhoneNumberRequest;
import com.tobeto.a.spring.intro.services.dtos.phoneNumber.responses.GetListPhoneNumberResponse;

import java.util.List;

public interface PhoneNumberService {
    void add(AddPhoneNumberRequest request);
    List<PhoneNumber> getByNumber(String number);
    List<GetListPhoneNumberResponse> getByNumberDto(String number);
    void update(UpdatePhoneNumberRequest request);
    void delete(DeletePhoneNumberRequest request);
}
