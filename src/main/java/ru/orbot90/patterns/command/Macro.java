package ru.orbot90.patterns.command;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by orbot on 13.06.16.
 */
public class Macro {

    private List<Action> actions;

    public Macro() {
        actions = new ArrayList<>();
    }

    public void record(Action action) {
        actions.add(action);
    }

    public void run() {
        for(Action action : actions) {
            action.perform();
        }
    }
}
