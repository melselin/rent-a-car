package com.tobeto.a.spring.intro.services.concretes;

import com.tobeto.a.spring.intro.entities.Color;
import com.tobeto.a.spring.intro.repositories.ColorRepository;
import com.tobeto.a.spring.intro.services.abstracts.ColorService;
import com.tobeto.a.spring.intro.services.dtos.color.requests.AddColorRequest;
import com.tobeto.a.spring.intro.services.dtos.color.requests.DeleteColorRequest;
import com.tobeto.a.spring.intro.services.dtos.color.requests.UpdateColorRequest;
import com.tobeto.a.spring.intro.services.dtos.color.responses.GetListColorResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ColorManager implements ColorService {

    private final ColorRepository colorRepository;


    @Override
    public List<Color> getAll() {
        return colorRepository.findAll();
    }

    @Override
    public void add(AddColorRequest request) {
        if(colorRepository.existsColorByName(request.getName())){
            throw new RuntimeException("Bu renk zaten mevcut");
        }
        Color color = new Color();
        color.setName(request.getName());
        colorRepository.save(color);
    }

    @Override
    public void update(UpdateColorRequest request) {
        if(colorRepository.existsColorByName(request.getName())){
            throw new RuntimeException("Bu renk zaten mevcut");
        }
        Color colorToUpdate = colorRepository.findById(request.getId()).orElseThrow();
        colorToUpdate.setName(request.getName());
        colorRepository.save(colorToUpdate);

    }

    @Override
    public void delete(DeleteColorRequest request) {
        Color colorToDelete = colorRepository.findById(request.getId()).orElseThrow();
        colorRepository.delete(colorToDelete);

    }

    @Override
    public Color getById(int id) {
        return colorRepository.findById(id).orElseThrow();
    }
}
