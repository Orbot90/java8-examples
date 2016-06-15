package ru.orbot90.streams;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

/**
 * Created by achist on 15.06.16.
 */
public class CreatingStreamsApp {

    public static void main(String[] args) {
        //Random int collection
        Collection<Integer> integers = DataGenerator.getRandomIntCollection(10000);

        //Count of values less then 250
        //old style
        long count = 0;
        for(Integer integer : integers) {
            if(integer < 250) {
                count++;
            }
        }
        System.out.println(count);

        //Stream API (creating stream from collection)
        count = integers.stream().filter(value -> value < 250).count();
        System.out.println(count);

        //Stream API (creating stream from array)
        Integer[] arrayOfIntegers = integers.toArray(new Integer[integers.size()]);
        count = Stream.of(arrayOfIntegers).filter(value -> value < 250).count();
        System.out.println(count);

        //Stream API (creating stream from part of array)
        count = Arrays.stream(arrayOfIntegers, 0, 5000).filter(value -> value < 250).count();
        System.out.println(count);

        //Creating infinite stram
        Stream<Double> infiniteStream = Stream.generate(Math::random);

        //Creating iterating stream
        Stream<Integer> iteratingStream = Stream.iterate(0, value -> value + 150);

        //Creating empty stream
        Stream<Integer> emptyStream = Stream.empty();

//        infiniteStream.limit(10).forEach(System.out::println);
//        iteratingStream.limit(10).forEach(System.out::println);
//        emptyStream.forEach(System.out::println);
    }
}
