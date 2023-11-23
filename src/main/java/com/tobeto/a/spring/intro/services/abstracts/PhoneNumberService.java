package com.tobeto.a.spring.intro.services.abstracts;

import com.tobeto.a.spring.intro.services.dtos.phoneNumber.requests.AddPhoneNumberRequest;
import com.tobeto.a.spring.intro.services.dtos.phoneNumber.requests.DeletePhoneNumberRequest;
import com.tobeto.a.spring.intro.services.dtos.phoneNumber.requests.UpdatePhoneNumberRequest;

public interface PhoneNumberService {
    void add(AddPhoneNumberRequest request);
    void update(UpdatePhoneNumberRequest request);
    void delete(DeletePhoneNumberRequest request);
}
