package com.karollotkowski.softwarehouse;

import com.karollotkowski.softwarehouse.app.Application;
import com.karollotkowski.softwarehouse.dev.Developer;
import com.karollotkowski.softwarehouse.dev.FortranDeveloper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SoftwareHouseFactory {

    private final List<Developer> developers = new ArrayList<>();

    protected void hireDeveloper(final Developer newJoiner) {
        developers.add(newJoiner);
    }

    @SuppressWarnings("deprecation")
    public Optional<Application> developNumericApp() {
        return developers.stream()
                .filter(developer -> developer instanceof FortranDeveloper)
                .findFirst()
                .map(this::codeApp);
    }

    private Application codeApp(final Developer developer) {
        return developer.code();
    }

}
