package ru.orbot90.exampleapps;

import ru.orbot90.pojos.OtherClass;

import java.util.function.Supplier;

/**
 * Created by orbot on 12.06.16.
 */
public class LambdaTranslationExample {

    /**
     * В стек-трейсе видно, что даже когда мы передаём лямбду в другой класс, метод вызывается из данного класса и
     * имеет имя наподобие lambda$main$0
     *
     * Однако, при использовании method reference новый метод не создаётся, а вызывается уже существующий
     */
    public static void main(String[] args) {
        Supplier<Void> supplier = () -> {
            throw new RuntimeException();
        };
        new OtherClass().callException(supplier);

//        Consumer<String> consumer = String::toUpperCase;
//        consumer.accept(null);
    }
}
