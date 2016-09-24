package com.twu.biblioteca.option;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.entity.Console;

public class ExitOption extends Option {
    private Console console;
    private BibliotecaApp bibliotecaApp;
    public ExitOption(int id, String name, BibliotecaApp bibliotecaApp) {
        super(id, name);
        this.console = bibliotecaApp.getConsole();
        this.bibliotecaApp = bibliotecaApp;
    }

    @Override
    public void execute() {
        console.println("Exit System!");
        bibliotecaApp.stop();
    }
}
