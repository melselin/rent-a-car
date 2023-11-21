package com.tobeto.a.spring.intro.controllers;

import com.tobeto.a.spring.intro.entities.GearShiftType;
import com.tobeto.a.spring.intro.repositories.GearShiftTypeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/gearShiftTypes")
public class GearShiftTypesController {
    private final GearShiftTypeRepository gearShiftTypeRepository;

    public GearShiftTypesController(GearShiftTypeRepository gearShiftTypeRepository) {
        this.gearShiftTypeRepository = gearShiftTypeRepository;
    }


    @GetMapping
    public List<GearShiftType> getAll(){
        List<GearShiftType> gearShiftTypes = gearShiftTypeRepository.findAll();
        return gearShiftTypes;
    }

    @GetMapping("{id}")
    public GearShiftType getById(@PathVariable int id){
        return gearShiftTypeRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody GearShiftType gearShiftType){
        gearShiftTypeRepository.save(gearShiftType);
    }

    @DeleteMapping
    public void delete(@PathVariable int id){
        GearShiftType gearShiftTypeToDelete = gearShiftTypeRepository.findById(id).orElseThrow();
        gearShiftTypeRepository.delete(gearShiftTypeToDelete);
    }

    @PutMapping
    public void update(@PathVariable int id, @RequestBody GearShiftType gearShiftType){
        GearShiftType gearShiftTypeToUpdate = gearShiftTypeRepository.findById(id).orElseThrow();
        gearShiftTypeToUpdate.setType(gearShiftType.getType());
        gearShiftTypeRepository.save(gearShiftTypeToUpdate);



    }
}

