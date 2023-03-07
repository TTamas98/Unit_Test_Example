package com.example.service;

import com.example.domain.Character;

import java.util.List;

public interface CharacterService {
    void createCharacter(Character character);
    Character getCharacterById(Long id);
    void updateCharacter(Character character);
    void deleteCharacter(Long id);
    void healCharacter(Character character, int healAmount);
    void levelUp(Character character);
    void takeDamage(Character character, int damage);
    void throwsErrorBecauseIHaveNoIdea();
    List<Character> getAllCharacters();
}
