package com.twu.biblioteca.option;

import com.twu.biblioteca.BibliotecaApp;

import java.util.List;

public class CheckOutMovieOption extends CheckOutItemOption{
    public CheckOutMovieOption(int id, String name, BibliotecaApp bibliotecaApp) {
        super(id, name, bibliotecaApp);
    }

    @Override
    public void printFailureInfo() {
        console.println("That Movie is not available.");
    }

    @Override
    public void printSuccessInfo() {
        console.println("Thank you!Enjoy the Movie");
    }

    @Override
    public void setItems(List itemAfterCheckout) {
        bibliotecaApp.setMovies(itemAfterCheckout);
    }

    @Override
    public List getCheckedoutItems() {
        return bibliotecaApp.getCheckedOutMovies();
    }

    @Override
    public List getAvailableItems() {
        return bibliotecaApp.getMovies();
    }
}
