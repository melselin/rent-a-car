package com.tobeto.a.spring.intro.services.abstracts;

import com.tobeto.a.spring.intro.entities.Color;
import com.tobeto.a.spring.intro.services.dtos.color.requests.AddColorRequest;
import com.tobeto.a.spring.intro.services.dtos.color.requests.DeleteColorRequest;
import com.tobeto.a.spring.intro.services.dtos.color.requests.UpdateColorRequest;
import com.tobeto.a.spring.intro.services.dtos.color.responses.GetListColorResponse;

import java.util.List;

public interface ColorService {
    List<Color> getAll();
    void add(AddColorRequest request);
    void update(UpdateColorRequest request);
    void delete(DeleteColorRequest request);
    Color getById(int id);
}
