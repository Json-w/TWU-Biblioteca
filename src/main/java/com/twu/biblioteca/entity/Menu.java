package com.twu.biblioteca.entity;

import java.util.List;

public class Menu {
    private List<Option> options;
    private Console console;

    public Menu(List<Option> options, Console console) {
        this.options = options;
        this.console = console;
    }

    public void show() {
        console.println("**********Menu**********");
        for (Option option : options) {
            console.println(option.getId()+"."+option.getName());
        }
    }
}
