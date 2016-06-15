package ru.orbot90.streams;

import java.util.Collection;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by achist on 15.06.16.
 */
public class DataGenerator {
    private static final Random RANDOM = new Random();

    public static Collection<Integer> getRandomIntCollection(int collectionSize) {
        return Stream.generate(RANDOM::nextInt).limit(collectionSize).collect(Collectors.toList());
    }
}
