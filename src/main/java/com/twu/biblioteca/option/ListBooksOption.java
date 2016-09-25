package com.twu.biblioteca.option;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.entity.Book;

public class ListBooksOption extends Option {
    public static final String COLUMN_GAP = "     ";

    public ListBooksOption(int id, String name, BibliotecaApp bibliotecaApp) {
        super(id, name, bibliotecaApp);
    }

    @Override
    public void execute() {
        for (Book book : bibliotecaApp.getBooks()) {
            console.println(book.toString());
        }
    }
}
