package ru.orbot90.patterns.templatemethod.newway;

import ru.orbot90.patterns.templatemethod.ApplicationDenied;

/**
 * Created by orbot on 13.06.16.
 */
public interface Criteria {
    void check() throws ApplicationDenied;
}
