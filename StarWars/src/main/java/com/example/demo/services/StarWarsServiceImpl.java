package com.example.demo.services;

import com.example.demo.dto.CharacterDTO;
import com.example.demo.repositories.CharacterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StarWarsServiceImpl implements StarWarsService{

    CharacterRepository characterRepository;

    public StarWarsServiceImpl(CharacterRepository characterRepository){
        this.characterRepository = characterRepository;
    }

    @Override
    public List<CharacterDTO> getCharacters(String name) {

        return characterRepository.findByName(name);

    }
}
