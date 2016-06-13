package ru.orbot90.patterns.command;

/**
 * Created by orbot on 13.06.16.
 */
public class EditorImpl implements Editor {
    @Override
    public void save() {
        System.out.println("Saving file");
    }

    @Override
    public void open() {
        System.out.println("Opening file");
    }

    @Override
    public void close() {
        System.out.println("Closing file");
    }
}
