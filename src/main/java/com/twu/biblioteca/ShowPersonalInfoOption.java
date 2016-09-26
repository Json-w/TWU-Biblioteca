package com.twu.biblioteca;

import com.twu.biblioteca.option.Option;

public class ShowPersonalInfoOption extends Option {
    public ShowPersonalInfoOption(int id, String name, BibliotecaApp bibliotecaApp) {
        super(id, name, bibliotecaApp);
    }

    @Override
    public void execute() {
        console.println(bibliotecaApp.getLoginUser().toString());
    }
}
