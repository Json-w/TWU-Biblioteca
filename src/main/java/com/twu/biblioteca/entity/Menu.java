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
            console.println(option.getId() + "." + option.getName());
        }
    }

    public List<Option> getOptions() {
        return options;
    }

    public void selectOption(int chooseResult) {
        int count = 0;
        for (Option option : options) {
            if (chooseResult == option.getId()) {
                count++;
                option.execute();
            }
        }
        if (count == 0) {
            console.println("invalid menu option,please enter correct option.");
        }
    }
}
