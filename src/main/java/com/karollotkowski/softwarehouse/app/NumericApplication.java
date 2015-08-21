package com.karollotkowski.softwarehouse.app;

public class NumericApplication implements Application {

    private final String codename;

    public NumericApplication(final String codename) {
        this.codename = codename;
    }

    @Override
    public String run() {
        return "Hello, I am " + codename;
    }
}
