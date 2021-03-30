package com.example.demo.repositories;

import com.example.demo.dto.CharacterDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CharacterRepositoryImpl implements CharacterRepository{

    @Override
    public List<CharacterDTO> findByName(String name) {
        List<CharacterDTO> characterDTOs = null;
        characterDTOs = loadDataBase();
        List<CharacterDTO> result = new ArrayList<>();

        if(characterDTOs == null){
            return null;
        }
        for(CharacterDTO c: characterDTOs){
            if(c.getName().contains(name))
                result.add(c);
        }

        return result;
    }

    private List<CharacterDTO> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars.json");
        }catch (Exception e){
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<CharacterDTO>> typeRef = new TypeReference<List<CharacterDTO>>() {};
        List<CharacterDTO> characterDTOs = null;

        try {
            characterDTOs = objectMapper.readValue(file, typeRef);

        }catch (Exception e){
            e.printStackTrace();
        }

        return characterDTOs;

    }
}
