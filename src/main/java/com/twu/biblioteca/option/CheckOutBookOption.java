package com.twu.biblioteca.option;

import com.twu.biblioteca.BibliotecaApp;

import java.util.List;

public class CheckOutBookOption extends CheckOutItemOption {


    public CheckOutBookOption(int id, String name, BibliotecaApp bibliotecaApp) {
        super(id, name, bibliotecaApp);
    }

    @Override
    public void printFailureInfo() {
        console.println("That book is not available.");
    }

    @Override
    public void printSuccessInfo() {
        console.println("Thank you!Enjoy the book");
    }

    @Override
    public void setItems(List itemAfterCheckout) {
        bibliotecaApp.setBooks(itemAfterCheckout);
    }

    @Override
    public List getCheckedoutItems() {
        return bibliotecaApp.getCheckedOutBooks();
    }

    @Override
    public List getAvailableItems() {
        return bibliotecaApp.getBooks();
    }
}
