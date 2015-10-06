package com.karollotkowski.game;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CombatSkillsTest {

    @Spy
    private CombatSkills combatSkills;

    private final Fixtures fixtures = new Fixtures();

    @Test
    public void willFightWhenAttackIsPhysical() {
        // given
        doReturn(fixtures.fightDamage).when(combatSkills).fight();

        // when
        final int damage = combatSkills.attack(AttackType.PHYSICAL);

        // then
        assertThat("Fight damage should match", damage, is(fixtures.fightDamage));

        verify(combatSkills).fight();
        verify(combatSkills, never()).spell();
    }

    @Test
    public void willSpellWhenAttackIsMagic() {
        // given
        doReturn(fixtures.spellDamage).when(combatSkills).spell();

        // when
        final int damage = combatSkills.attack(AttackType.MAGICAL);

        // then
        assertThat("Spell damage should match", damage, is(fixtures.spellDamage));

        verify(combatSkills, never()).fight();
        verify(combatSkills).spell();
    }

    @Test
    public void willSpellWhenAttackIsNotDefined() {
        // given
        doReturn(fixtures.fightDamage).when(combatSkills).fight();
        doReturn(fixtures.spellDamage).when(combatSkills).spell();

        // when
        final int damage = combatSkills.attack(fixtures.attackTypeNotDefined);

        // then
        assertThat("Spell damage should match", damage, is(fixtures.spellDamage));

        verify(combatSkills, never()).fight();
        verify(combatSkills).spell();
    }

    private class Fixtures {
        private final int spellDamage = 2;
        private final int fightDamage = 7;

        private final AttackType attackTypeNotDefined = null;
    }
}
