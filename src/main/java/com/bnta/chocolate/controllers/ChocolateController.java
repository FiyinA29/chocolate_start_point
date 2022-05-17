package com.bnta.chocolate.controllers;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.repositories.ChocolateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;




@RestController //Marks the class as a controller where every method returns a domain object instead of a view
@RequestMapping("chocolates")// localhost:8080/chocolates
public class ChocolateController {

    @Autowired
    ChocolateRepository chocolateRepository;

    @GetMapping //Maps HTTP Get requests onto specific handler methods.
    public ResponseEntity<List<Chocolate>> getAllChocolatesAndFilters() {
        //ResponseEntity represents the entire HTTP response
        return new ResponseEntity<>(chocolateRepository.findAll(), HttpStatus.OK);
    }

    // SHOW
    @GetMapping(value = "/{id}") //localhost:8080/chocolates/1
    public ResponseEntity<Optional<Chocolate>> getPet(@PathVariable Long id){
        return new ResponseEntity<>(chocolateRepository.findById(id), HttpStatus.OK);
    }

    // POST
    @PostMapping //POST localhost:8080/chocolates
    public ResponseEntity<Chocolate> createPet(@RequestBody Chocolate newChocolate){
        chocolateRepository.save(newChocolate);
        return new ResponseEntity<>(newChocolate, HttpStatus.CREATED);
    }
}
