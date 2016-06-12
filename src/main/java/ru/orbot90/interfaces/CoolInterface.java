package ru.orbot90.interfaces;

import java.util.Objects;

/**
 * Простой функциональный интерфейс с одним абстрактным методом doStuff
 */
@FunctionalInterface
public interface CoolInterface {

    void doStuff();

    default CoolInterface doMoreStuff(CoolInterface coolInterface) {
        Objects.requireNonNull(coolInterface);
        return () -> {
            doStuff();
            coolInterface.doStuff();
        };
    }
}
