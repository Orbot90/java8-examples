package ru.orbot90.streams;

import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by chistyakov on 16.06.2016.
 */
public class TransformationStreamsApp {

    public static void main(String[] args) {
        integerStreamExample(true);
        integerStreamExample(false);
        stringStreamExample();
        doubleStreamExample();
        iterateStreamExample();
        findExample();
        collectingData();

        //Создание пустого потока
        Stream<String> emptyStream = Stream.empty();
    }

    private static void integerStreamExample(boolean isMax) {
        System.out.println("integers stream example with isMax = " + isMax + ", started");
        Collection<Integer> integers = DataGenerator.getRandomIntCollection(10);

        //Создание стрима из коллекции
        Stream<Integer> integerStream = integers.stream();

        //Применение фильтра к коллекции, получаем стрим с четными интами
        //Метод peek использован, для наглядности, чтоб вывести данные из потока
        Stream<Integer> onlyEvenIntegerStream = integerStream.filter(value -> value % 2 == 0)
                .peek(value -> System.out.print(value + " "));

        //применение метода сведения в зависимости от переданного флага max или min
        Optional<Integer> value;
        if(isMax) {
            value = onlyEvenIntegerStream.max(Integer::compare);
        } else {
            value = onlyEvenIntegerStream.min(Integer::compare);
        }

        //выводим полученный результат, либо выкидываем исключение если поток ВНЕЗАПНО пустой
        System.out.println("\nvalue = " + value.orElseThrow(RuntimeException::new));
        System.out.println("integers stream example with isMax = " + isMax + ", finished\n");
    }

    private static void stringStreamExample() {
        System.out.println("string stream example started");
        String[] strings = new String[]{"transfer", "cheque", "between", "accounts"};

        //Создание потока с помощью статического метода of
        Stream<String> wordsStream = Stream.of("transfer", "cheque", "between", "accounts");
        //Создание потока из части массива
        Stream<String> twoWordsStream = Arrays.stream(strings, 0, 2);

        //Получаем поток данных, в котором все слова из исходного потока, приведены к верхнему регистру
        Stream<String> upperCaseWordsStream = wordsStream.map(String::toUpperCase);

        //Получить поток данных, содержащий только первые буквы слов из исходного потока данных
        Stream<String> onlyFirstLettersStream = upperCaseWordsStream.map(value -> value.substring(0, 1));

        //Получение стрима стримов содержащих слова разбитые по буквам
        //Должен быть закомменчен, т.к. иначе при повторной попытке преобразовать уже преобразованный поток
        //получим исключение.
        //Stream<Stream<String>> stramOfStreams = twoWordsStream.map(value -> getLettersStream(value));

        //Получение годного стрима содержащего слова разбитые по буквам
        Stream<String> lettersStream = twoWordsStream.flatMap(value -> getLettersStream(value));

        //Объединение двух потоков
        Stream<String> concatenatedStreams = Stream.concat(onlyFirstLettersStream, lettersStream);

        //Получение потока содержащего все элементы из исходного потока, без повторений
        //Метод peek использован, для наглядности, чтоб вывести данные из потока
        Stream<String> distinctLettersStream = concatenatedStreams.distinct()
                .peek(value -> System.out.print(value + " "));

        System.out.print("result = ");

        //Используем метод сведения count, отдающий количество элементов в потоке
        long count = distinctLettersStream.count();

        System.out.println("\nCount: " + count);
        System.out.println("string stream example finished\n");
    }

    private static void doubleStreamExample() {
        System.out.println("double stream example started");

        //Создание бесконечного потока рандомных даблов
        Stream<Double> infiniteStream = Stream.generate(Math::random);

        //Ограничиваем размер потока десятью
        Stream<Double> tenDoubleStream = infiniteStream.limit(10);

        //Сортируем данные из потока, можно так, т.к Double имплементит Comparable, так же можно использовать компаратор
        Stream<Double> sortedDoubleStream = tenDoubleStream.sorted();

        System.out.print("values: ");
        sortedDoubleStream.forEach(value -> System.out.print(value + " "));
        System.out.println("\ndouble stream example finished\n");
    }

    private static void iterateStreamExample() {
        System.out.println("iterate stream example started");
        //Создание стрима с последовательностью
        Stream<Integer> iterateStream = Stream.iterate(1, value -> value + 100);

        //Пропускаем первые 10 элементов
        Stream<Integer> iterateStreamMoteThenThousand = iterateStream.skip(10);

        //Лимит тут ставим только для того чтоб не уйти в бесконечный цикл
        iterateStreamMoteThenThousand.limit(10).forEach(value -> System.out.print(value + " "));
        System.out.println("\niterate stream example finished\n");
    }

    private static void findExample() {
        System.out.println("find example started");

        //Создание потока с помощью статического метода of
        Stream<String> wordsStream = Stream.of("transfer", "cheque", "between", "accounts");

        //Находим первый элемент потока
        //Optional<String> found = wordsStream.findFirst();

        //Находим любой элемент (без смысла если используется без filter() и в одном потоке)
        //Optional<String> found = wordsStream.findAny();

        //Проверка совпадения хотя бы единождыя
        //boolean matches = wordsStream.anyMatch(value -> value.length() == 5);

        //Проверка совпадения всех элементов
        //boolean matches = wordsStream.allMatch(value -> value != null);

        //Проверка того что не совпадает ни один элемент
        boolean noneMatches = wordsStream.noneMatch(value -> value.length() == 777);
        //System.out.println("Value = " + found.orElseThrow(RuntimeException::new));
        System.out.println("find example finished\n");
    }

    private static void collectingData() {
        System.out.println("collecting example started");

        //Создание потока с помощью статического метода of
        Stream<String> wordsStream = Stream.of("transfer", "cheque", "between", "accounts");

        //Собираем данные в коллекцию
        //Collection<String> collection = wordsStream.collect(Collectors.toList());

        //Сцепляем строки из потока через запятую
        //String data = wordsStream.collect(Collectors.joining(", "));

//        IntSummaryStatistics summary = wordsStream.collect(Collectors.summarizingInt(String::length));
//        System.out.println(summary.getMax());
//        System.out.println(summary.getMin());
//        System.out.println(summary.getSum());
//        System.out.println(summary.getAverage());

//        Map<Integer, List<String>> collect = wordsStream.collect(Collectors.groupingBy(s -> s.length()));
        int stringsLength = wordsStream.reduce(0, (total, string) -> total + string.length(), Integer::sum);
        System.out.println("collecting example finished\n");
    }

    private static Stream<String> getLettersStream(String string) {
        return Pattern.compile("").splitAsStream(string);
    }
}
