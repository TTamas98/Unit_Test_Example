package com.example.service;

import com.example.domain.Character;
import com.example.domain.dao.CharacterDAO;

import java.util.List;

public class CharacterServiceImpl implements CharacterService {
    private CharacterDAO characterDAO;

    public CharacterServiceImpl(CharacterDAO characterDAO) {
        this.characterDAO = characterDAO;
    }

    public void createCharacter(Character character) {
        characterDAO.saveCharacter(character);
    }

    public Character getCharacterById(Long id) {
        return characterDAO.getCharacterById(id);
    }

    public void updateCharacter(Character character) {
        characterDAO.updateCharacter(character);
    }

    public void deleteCharacter(Long id) {
        characterDAO.deleteCharacter(id);
    }

    public void levelUp(Character character) {
        int currentLevel = character.getLevel();
        int newLevel = currentLevel + 1;
        character.setLevel(newLevel);
        characterDAO.updateCharacter(character);
    }

    public void takeDamage(Character character, int damage) {
        int currentHealth = character.getHealth();
        int newHealth = currentHealth - damage;
        if (newHealth <= 0) {
            character.setHealth(0);
            characterDAO.deleteCharacter(character.getId());
        } else {
            character.setHealth(newHealth);
            characterDAO.updateCharacter(character);
        }
    }

    @Override
    public void healCharacter(Character character, int healAmount) {
        int currentHealth = character.getHealth();
        character.setHealth(currentHealth + healAmount);
        characterDAO.updateCharacter(character);
    }

    @Override
    public void throwsErrorBecauseIHaveNoIdea() {
        throw new IllegalArgumentException();
    }

    public List<Character> getAllCharacters() {
        return characterDAO.getAllCharacters();
    }
}

