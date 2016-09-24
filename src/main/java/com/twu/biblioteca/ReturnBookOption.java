package com.twu.biblioteca;

import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.entity.Console;
import com.twu.biblioteca.entity.Option;

import java.util.ArrayList;
import java.util.List;

public class ReturnBookOption extends Option {
    private Console console;
    private BibliotecaApp bibliotecaApp;

    public ReturnBookOption(int id, String name,BibliotecaApp bibliotecaApp) {
        super(id, name);
        this.bibliotecaApp = bibliotecaApp;
        this.console = bibliotecaApp.getConsole();
    }

    @Override
    public void execute() {
        String readyReturnBookName = console.getNextString();
        validateBookAndDeleteItOnCheckedOutBooks(readyReturnBookName);
    }

    private boolean validateBookAndDeleteItOnCheckedOutBooks(String readyReturnBookName) {
        List<Book> checkedOutBooks = bibliotecaApp.getCheckedOutBooks();
        for (Book book : checkedOutBooks) {
            if (book.getName().equals(readyReturnBookName)) {
                checkedOutBooks.remove(book);
                bibliotecaApp.getBooks().add(book);
                bibliotecaApp.setCheckedOutBooks(checkedOutBooks);
                return true;
            }
        }
        return false;
    }
}
