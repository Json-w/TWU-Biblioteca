package com.twu.biblioteca.option;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.entity.Console;

public class ListBooksOption extends Option {
    public static final String COLUMN_GAP = "     ";

    private BibliotecaApp bibliotecaApp;
    private Console console;

    public ListBooksOption(int id, String name,BibliotecaApp bibliotecaApp) {
        super(id, name);
        this.bibliotecaApp = bibliotecaApp;
        this.console = bibliotecaApp.getConsole();
    }

    @Override
    public void execute() {
        for (Book book : bibliotecaApp.getBooks()) {
            console.println(book.toString());
        }
    }
}
