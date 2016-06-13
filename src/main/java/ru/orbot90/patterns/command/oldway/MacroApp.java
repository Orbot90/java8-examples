package ru.orbot90.patterns.command.oldway;

import ru.orbot90.patterns.command.Editor;
import ru.orbot90.patterns.command.EditorImpl;
import ru.orbot90.patterns.command.Macro;

/**
 * Created by orbot on 13.06.16.
 */
public class MacroApp {
    public static void main(String[] args) {
        Editor editor = new EditorImpl();

        Macro macro = new Macro();
        macro.record(new Open(editor));
        macro.record(new Save(editor));
        macro.record(new Close(editor));
        macro.run();
    }
}
