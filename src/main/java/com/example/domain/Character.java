package com.example.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Character {
    private Long id;
    private String name;
    private int level;
    private int health;
    private int mana;
    private int strength;
    private int agility;
    private int intelligence;
    private int wisdom;
    private int charisma;
}