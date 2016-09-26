package com.twu.biblioteca;

import com.twu.biblioteca.entity.User;
import com.twu.biblioteca.option.Option;

public class LoginOption extends Option {

    public LoginOption(int id, String name, BibliotecaApp bibliotecaApp) {
        super(id, name, bibliotecaApp);
    }

    @Override
    public void execute() {
        console.print("username:");
        String username = console.getNextString();
        console.print("password:");
        String password = console.getNextString();

        for (User user : bibliotecaApp.getUsers()) {
            validateUser(username, password, user);
        }
    }

    private void validateUser(String username, String password, User user) {
        if (user.getUsername().equals(username)) {
            if (user.getPassword().equals(password)) {
                console.println("Welcome " + username);
            } else {
                console.println("please input correct username and password!");
            }
        } else {
            console.println("please input correct username and password!");
        }
    }
}
