package com.tobeto.a.spring.intro.services.abstracts;

import com.tobeto.a.spring.intro.services.dtos.identity.requests.AddIdentityRequest;
import com.tobeto.a.spring.intro.services.dtos.identity.requests.DeleteIdentityRequest;
import com.tobeto.a.spring.intro.services.dtos.identity.requests.UpdateIdentityRequest;
import com.tobeto.a.spring.intro.services.dtos.identity.responses.GetListIdentityResponse;

import java.util.List;

public interface IdentityService {
    void add(AddIdentityRequest request);
    List<GetListIdentityResponse> getByNationalId(String nationalId);
    List<GetListIdentityResponse> getByNationalIdDto(String nationalId);

    void update(UpdateIdentityRequest request);
    void delete(DeleteIdentityRequest request);
}
