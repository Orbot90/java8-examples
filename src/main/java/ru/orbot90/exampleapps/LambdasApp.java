package ru.orbot90.exampleapps;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.*;
import java.util.stream.Collectors;

/**
 * Created by orbot on 12.06.16.
 */
public class LambdasApp {
    public static void main(String[] args) {
//        consumerExample();
//        functionExample();
//        predicateExample();
//        streamPredicateExample();
//        supplierExample();
//        operatorExample();
    }

    private static void consumerExample() {
        Consumer<String> consumer = System.out::println;
        consumer = consumer.andThen(x -> System.out.println("After printing " + x));

        consumer.accept("Ha ha ha");
    }

    private static void functionExample() {
        Function<String, String> function = String::toUpperCase;
        function = function.compose(x -> x + ". Это добавлено перед вызовом функции. ");
        function = function.andThen(x -> x + "Это добавлено после вызова функции.");


        String result = function.apply("hate");
        System.out.println(result);
    }

    private static void predicateExample() {
        Predicate<Integer> predicate = x -> x < 50;
        System.out.println(predicate.test(1));
    }

    private static void streamPredicateExample() {
        Predicate<Integer> predicate = x -> x < 50;

        List<Integer> randomList = new ArrayList<>();
        Random random = new Random();
        for(int i = 0; i < 100; i++) {
            randomList.add(random.nextInt(100));
        }
        System.out.println(randomList);

        randomList = randomList
                        .stream()
                        .filter(predicate)
                        .collect(Collectors.toList());
        System.out.println(randomList);
    }

    private static void supplierExample() {
        Supplier<String> supplier = () -> "Supplied " + "string";

        System.out.println(supplier.get());
    }

    private static void operatorExample() {

        UnaryOperator<String> addSomeShit = (str) -> str + " some shit";

        String result = addSomeShit.apply("Some cool stuff and");
        System.out.println(result);
    }
}
