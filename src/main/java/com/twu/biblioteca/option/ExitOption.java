package com.twu.biblioteca.option;

import com.twu.biblioteca.BibliotecaApp;

public class ExitOption extends Option {
    public ExitOption(int id, String name, BibliotecaApp bibliotecaApp) {
        super(id, name, bibliotecaApp);
    }

    @Override
    public void execute() {
        console.println("Exit System!");
        bibliotecaApp.stop();
    }
}
