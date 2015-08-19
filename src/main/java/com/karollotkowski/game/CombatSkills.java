package com.karollotkowski.game;

public abstract class CombatSkills {

    public int attack(final AttackType attackType) {
        return attackType == AttackType.PHYSICAL ? fight() : spell();
    }

    protected abstract int fight();

    protected abstract int spell();
}