package com.example.demo.repositories;

import com.example.demo.dto.CharacterDTO;

import java.util.List;

public interface CharacterRepository {

    List<CharacterDTO> findByName(String name);
}
