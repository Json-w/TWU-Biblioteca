package com.twu.biblioteca;

import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.entity.Console;
import com.twu.biblioteca.entity.Option;

import java.util.ArrayList;
import java.util.List;

public class CheckOutBookOption extends Option{

    private BibliotecaApp bibliotecaApp;
    private Console console;

    public CheckOutBookOption(int id, String name, BibliotecaApp bibliotecaApp) {
        super(id, name);
        this.bibliotecaApp = bibliotecaApp;
        this.console = bibliotecaApp.getConsole();
    }

    @Override
    public void execute() {
        String checkoutBookName = console.getNextString();
        List<Book> booksAfterCheckout = new ArrayList<Book>();
        //// TODO: 9/22/16 check if the list can directly remove item
        for (Book book : bibliotecaApp.getBooks()) {
            if (!checkoutBookName.equals(book.getName())){
                booksAfterCheckout.add(book);
            }
        }
        bibliotecaApp.setBooks(booksAfterCheckout);
    }
}
