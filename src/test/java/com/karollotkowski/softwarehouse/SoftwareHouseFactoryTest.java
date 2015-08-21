package com.karollotkowski.softwarehouse;

import com.karollotkowski.softwarehouse.app.Application;
import com.karollotkowski.softwarehouse.dev.Developer;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SoftwareHouseFactoryTest {

    private SoftwareHouseFactory softwareHouse;

    @Before
    public void setUp() {
        softwareHouse = new SoftwareHouseFactory();
    }

    @SuppressWarnings("deprecation")
    @Test
    public void willDevelopNumericAppWhenFortranDeveloperIsHired() {
        // given
        final Developer fortranDeveloper = new com.karollotkowski.softwarehouse.dev.FortranDeveloper();
        softwareHouse.hireDeveloper(fortranDeveloper);

        // when
        final Optional<Application> application = softwareHouse.developNumericApp();

        // then
        assertThat("We are rich", application.isPresent(), is(true));
    }

    @Test
    public void willNotDevelopNumericAppWhenLastFortranDeveloperDied20YearsAgo() {
        // given
        // when
        final Optional<Application> application = softwareHouse.developNumericApp();

        // then
        assertThat("We are losers", application.isPresent(), is(false));
    }
}