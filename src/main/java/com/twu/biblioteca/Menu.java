package com.twu.biblioteca;

import java.util.List;

public class Menu {
    private List<Option> options;

    public Menu(List<Option> options) {
        this.options = options;
    }

    public void show() {
        System.out.println("**********Menu**********");
        for (Option option : options) {
            System.out.println(option.getId()+"."+option.getName());
        }
    }
}
