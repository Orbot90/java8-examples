package ru.orbot90.pojos;

import java.util.function.Supplier;

/**
 * Created by orbot on 12.06.16.
 */
public class OtherClass {
    public void callException(Supplier<Void> supplier) {
        supplier.get();
    }
}
