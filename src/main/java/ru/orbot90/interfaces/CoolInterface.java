package ru.orbot90.interfaces;

/**
 * Created by plevako on 10.06.2016.
 */
@FunctionalInterface
public interface CoolInterface {

    void doStuff();

    default CoolInterface doMoreStuff(CoolInterface coolInterface) {
        return () -> {
            doStuff();
            coolInterface.doStuff();
        };
    }
}
