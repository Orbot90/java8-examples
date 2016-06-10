package ru.orbot90.exampleapps;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by plevako on 10.06.2016.
 */
public class CompletableFutureApp {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(() -> {
            pause(10_000L);
            return "Some string";
        });
        String someString = future.get();
        System.out.println("After future");
        String modifiedString = someString + " was modified";
        System.out.println(modifiedString);

//        CompletableFuture.supplyAsync(() -> {
//            pause(10_000L);
//            return "Some string";
//        }).thenApply(string -> string + " was modified")
//                .thenAccept(System.out::println);
//
//        System.out.println("After completable future");
//
//
//        // Приложение продолжает работать
//        pause(12_000L);
    }


    private static void pause(Long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
