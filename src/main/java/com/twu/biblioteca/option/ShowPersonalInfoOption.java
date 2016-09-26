package com.twu.biblioteca.option;

import com.twu.biblioteca.BibliotecaApp;

public class ShowPersonalInfoOption extends Option {
    public ShowPersonalInfoOption(int id, String name, BibliotecaApp bibliotecaApp) {
        super(id, name, bibliotecaApp);
    }

    @Override
    public void execute() {
        console.println(bibliotecaApp.getLoginUser().toString());
    }
}
