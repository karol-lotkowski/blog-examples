package com.karollotkowski.game;

import java.util.Random;

public class WarriorSkills extends CombatSkills {

    private static final int STRENGTH = 10;
    private static final int MANA = 0;
    private final Random random = new Random();

    @Override
    protected int fight() {
        return new random.ints(0, STRENGTH).findFirst().getAsInt();
    }

    @Override
    protected int spell() {
        return MANA;
    }
}
