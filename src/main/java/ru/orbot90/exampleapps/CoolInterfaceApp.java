package ru.orbot90.exampleapps;

import ru.orbot90.interfaces.CoolInterface;

/**
 * Created by plevako on 10.06.2016.
 */
public class CoolInterfaceApp {
    /**
     * Простой вариант своей лямбды из своего функционального интерфейса
     */
    public static void main(String[] args) {

        CoolInterface coolInterface = () -> System.out.println("cool stuff");
        coolInterface = coolInterface.doMoreStuff(() -> System.out.println("More cool stuff"));
        coolInterface.doStuff();

    }
}
