package com.karollotkowski.softwarehouse.dev;

import com.karollotkowski.softwarehouse.app.Application;
import com.karollotkowski.softwarehouse.app.NumericApplication;

@Deprecated
public class FortranDeveloper implements Developer {

    @Override
    public Application code() {
        return new NumericApplication("Numerical weather prediction");
    }
}
