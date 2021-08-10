package com.example.demo.service;

import com.example.demo.model.Avenger;
import com.example.demo.repository.AvengersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class AvengersService {

    @Autowired
    AvengersRepository avengersRepository;

    //GET Method
    public List<Avenger> getAll() {
        return avengersRepository.findAll();
    }

    //GET by ID Method
    public Optional<Avenger> getAvengerById(Long id) {
        return avengersRepository.findById(id);
    }

    //Post Method
    public ResponseEntity<Avenger> createAvenger(Avenger avenger) {
        avengersRepository.save(avenger);
        return ResponseEntity.ok(avenger);
    }

    //PUT Method
    @Transactional
    public ResponseEntity<Avenger> updateAvenger(Avenger avenger, Long id) throws IllegalStateException{
        Optional<Avenger> avengerUp = avengersRepository.findById(id);
        if (avengerUp.isPresent()){
            avengersRepository.save(avengerUp.get());
            return ResponseEntity.ok(avenger);
        }
        return ResponseEntity.notFound().build();

    }

    //DELETE Method
    public ResponseEntity<Avenger> deleteAvengerById(Long id) {
        avengersRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
