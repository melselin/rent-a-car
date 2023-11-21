package com.tobeto.a.spring.intro.controllers;

import com.tobeto.a.spring.intro.entities.Color;
import com.tobeto.a.spring.intro.repositories.ColorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/colors")
public class ColorsController {
    private final ColorRepository colorRepository;

    public ColorsController(ColorRepository colorRepository) {
        this.colorRepository = colorRepository;
    }

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
    public void add(@RequestBody Color color){
        colorRepository.save(color);
    }

    @DeleteMapping
    public void delete(@PathVariable int id){
        Color colorToDelete = colorRepository.findById(id).orElseThrow();
        colorRepository.delete(colorToDelete);
    }

    @PutMapping
    public void update(@PathVariable int id, @RequestBody Color color){
        Color colorToUpdate = colorRepository.findById(id).orElseThrow();
        colorToUpdate.setColor(color.getColor());
        colorRepository.save(colorToUpdate);

    }
}
