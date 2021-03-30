package com.example.demo.controllers;

import com.example.demo.services.StarWarsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/StarWars")
public class StarWarsController {

    @Autowired
    StarWarsServiceImpl starWarsService;

    @GetMapping("{name}")
    public ResponseEntity getCharacters(@PathVariable String name){

        return new ResponseEntity(starWarsService.getCharacters(name), HttpStatus.OK);
    }
}
