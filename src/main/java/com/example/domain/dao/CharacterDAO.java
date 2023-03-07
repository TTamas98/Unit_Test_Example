package com.example.domain.dao;

import com.example.domain.Character;

import java.util.List;

public interface CharacterDAO {
    void saveCharacter(Character character);
    Character getCharacterById(Long id);
    void updateCharacter(Character character);
    void deleteCharacter(Long id);
    List<Character> getAllCharacters();
}

