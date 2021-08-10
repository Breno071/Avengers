package com.example.demo.controller;

import com.example.demo.model.Avenger;
import com.example.demo.service.AvengersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;


@RestController
@RequestMapping("avengers/")
public class Controller {

    @Autowired
    AvengersService avengersService;

    @GetMapping
    public List<Avenger> getAllAvengers() {
        return avengersService.getAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Avenger> getbyID(@PathVariable(value = "id") Long id) throws NoSuchElementException {
        return ResponseEntity.ok(avengersService.getAvengerById(id).orElseThrow(() -> new NoSuchElementException("Vingador não encontrado")));
    }

    @PostMapping
    public ResponseEntity<Avenger> createAvenger(@RequestBody Avenger avenger) {
        return avengersService.createAvenger(avenger);
    }

    @PutMapping("{id}")
    public ResponseEntity<Avenger> putAvenger(@PathVariable(name = "id") Long id, @RequestBody Avenger avenger){
        return avengersService.updateAvenger(avenger, id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Avenger> deleteAvenger(@PathVariable(value = "id") Long id){
        return avengersService.deleteAvengerById(id);
    }

}
