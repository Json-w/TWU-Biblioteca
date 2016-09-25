package com.twu.biblioteca.option;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.entity.Console;

public abstract class Option implements Executable{

    private int id;
    private String name;
    protected BibliotecaApp bibliotecaApp;
    protected Console console;

    public Option(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Option(int id, String name, BibliotecaApp bibliotecaApp) {
        this.id = id;
        this.name = name;
        this.bibliotecaApp = bibliotecaApp;
        this.console = bibliotecaApp.getConsole();
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
