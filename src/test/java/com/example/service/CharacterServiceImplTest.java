package com.example.service;

import com.example.domain.Character;
import com.example.domain.dao.ListCharacterDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

public class CharacterServiceImplTest {

    private static final int TEST_ATTRIBUTE_VALUE = 1;
    private static final Long TEST_ID = 1L;
    private static final String TEST_NAME = "Test Character";
    private static final int TEST_LEVEL = 12;

    private CharacterService underTest;

    @BeforeEach
    public void setUp() {
        underTest = new CharacterServiceImpl(new ListCharacterDAO());
    }

    @Test
    public void testSaveAndGetCharacter() {
        // GIVEN
        Character character = createCharacter();

        // WHEN
        underTest.createCharacter(character);

        // THEN
        Character retrieved = underTest.getCharacterById(character.getId());
        Assertions.assertEquals(character, retrieved);
    }

    @Test
    public void testUpdateCharacter() {
        // GIVEN
        Character character = createCharacter();
        underTest.createCharacter(character);
        character.setIntelligence(100);

        // WHEN
        underTest.updateCharacter(character);

        // THEN
        Character updated = underTest.getCharacterById(character.getId());
        Assertions.assertEquals(character, updated);
    }

    @Test
    public void testDeleteCharacter() {
        // GIVEN
        Character character = createCharacter();
        underTest.createCharacter(character);

        // WHEN
        underTest.deleteCharacter(character.getId());

        // THEN
        Character deleted = underTest.getCharacterById(character.getId());
        Assertions.assertNull(deleted);
    }

    @Test
    public void testGetAllCharacters() {
        // GIVEN
        Character character1 = createCharacter();
        Character character2 = createCharacter();
        underTest.createCharacter(character1);
        underTest.createCharacter(character2);

        // WHEN
        List<Character> characters = underTest.getAllCharacters();

        // THEN
        Assertions.assertEquals(2, characters.size());
        Assertions.assertTrue(characters.contains(character1));
        Assertions.assertTrue(characters.contains(character2));
    }

    @ParameterizedTest()
    @CsvSource({"1","2","3","4","5","6"})
    public void testHealCharacter(int healAmount) {
        // GIVEN
        Character character = createCharacter();
        int expected = character.getHealth() + healAmount;
        underTest.createCharacter(character);

        // WHEN
        underTest.healCharacter(character, healAmount);

        // THEN
        Character actual = underTest.getCharacterById(TEST_ID);
        Assertions.assertEquals(expected, actual.getHealth());
    }

    @Test
    public void testThrowMethod_shouldThrowIllegalArgumentException() {
        // GIVEN
        // WHEN
        Assertions.assertThrows(IllegalArgumentException.class, () -> underTest.throwsErrorBecauseIHaveNoIdea());
        // THEN
    }

    private Character createCharacter() {
        return Character.builder()
                .id(TEST_ID)
                .name(TEST_NAME)
                .agility(TEST_ATTRIBUTE_VALUE)
                .charisma(TEST_ATTRIBUTE_VALUE)
                .health(TEST_ATTRIBUTE_VALUE)
                .mana(TEST_ATTRIBUTE_VALUE)
                .level(TEST_LEVEL)
                .intelligence(TEST_ATTRIBUTE_VALUE)
                .strength(TEST_ATTRIBUTE_VALUE)
                .wisdom(TEST_ATTRIBUTE_VALUE)
                .build();
    }
}
