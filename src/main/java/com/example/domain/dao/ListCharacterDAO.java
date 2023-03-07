package com.example.domain.dao;

import com.example.domain.Character;

import java.util.ArrayList;
import java.util.List;

public class ListCharacterDAO implements CharacterDAO {
    private List<Character> characters;

    public ListCharacterDAO() {
        this.characters = new ArrayList<>();
    }

    @Override
    public void saveCharacter(Character character) {
        characters.add(character);
    }

    @Override
    public Character getCharacterById(Long id) {
        for (Character character : characters) {
            if (character.getId() == id) {
                return character;
            }
        }
        return null;
    }

    @Override
    public void updateCharacter(Character character) {
        for (int i = 0; i < characters.size(); i++) {
            if (characters.get(i).getId() == character.getId()) {
                characters.set(i, character);
                return;
            }
        }
    }

    @Override
    public void deleteCharacter(Long id) {
        for (int i = 0; i < characters.size(); i++) {
            if (characters.get(i).getId() == id) {
                characters.remove(i);
                return;
            }
        }
    }

    @Override
    public List<Character> getAllCharacters() {
        return characters;
    }
}

