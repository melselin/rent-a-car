package com.tobeto.a.spring.intro.controllers;

import com.tobeto.a.spring.intro.entities.Color;
import com.tobeto.a.spring.intro.repositories.ColorRepository;
import com.tobeto.a.spring.intro.services.abstracts.ColorService;
import com.tobeto.a.spring.intro.services.dtos.color.requests.AddColorRequest;
import com.tobeto.a.spring.intro.services.dtos.color.requests.DeleteColorRequest;
import com.tobeto.a.spring.intro.services.dtos.color.requests.UpdateColorRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/colors")
public class ColorsController {
    private final ColorService colorService;
    private final ColorRepository colorRepository;


    @GetMapping
    public List<Color> getAll(){
        List<Color> colors = colorRepository.findAll();
        return colors;
    }

    @GetMapping("{id}")
    public Color getById(@PathVariable int id){
        return colorRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody AddColorRequest request){
        colorService.add(request);
    }

    @DeleteMapping
    public void delete(@PathVariable DeleteColorRequest request){ colorService.delete(request);
    }

    @PutMapping
    public void update(@PathVariable int id, @RequestBody @Valid UpdateColorRequest request){ colorService.update(request);

    }
}
