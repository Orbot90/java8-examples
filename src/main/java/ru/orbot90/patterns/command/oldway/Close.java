package ru.orbot90.patterns.command.oldway;

import ru.orbot90.patterns.command.Action;
import ru.orbot90.patterns.command.Editor;

/**
 * Created by orbot on 13.06.16.
 */
class Close implements Action {

    private final Editor editor;

    Close(Editor editor) {
        this.editor = editor;
    }

    @Override
    public void perform() {
        editor.close();
    }
}
