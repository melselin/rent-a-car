package com.tobeto.a.spring.intro.services.abstracts;

import com.tobeto.a.spring.intro.services.dtos.identity.requests.AddIdentityRequest;
import com.tobeto.a.spring.intro.services.dtos.identity.requests.DeleteIdentityRequest;
import com.tobeto.a.spring.intro.services.dtos.identity.requests.UpdateIdentityRequest;

public interface IdentityService {
    void add(AddIdentityRequest request);
    void update(UpdateIdentityRequest request);
    void delete(DeleteIdentityRequest request);
}
