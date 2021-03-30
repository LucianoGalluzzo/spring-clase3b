package com.example.demo.services;

import com.example.demo.dto.CharacterDTO;

import java.util.List;

public interface StarWarsService {

    List<CharacterDTO> getCharacters(String name);
}
