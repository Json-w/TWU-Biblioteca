package com.twu.biblioteca.option;

import com.twu.biblioteca.BibliotecaApp;

import java.util.List;

public class ReturnMovieOption extends ReturnItemOption{
    public ReturnMovieOption(int id, String name, BibliotecaApp bibliotecaApp) {
        super(id, name, bibliotecaApp);
    }

    @Override
    public void printSuccessInfo() {
        console.println("Thank you for returning the movie.");
    }

    @Override
    public void printFailureInfo() {
        console.println("That is not a valid movie to return.");
    }

    @Override
    public void setCheckedOutItems(List checkedOutItems) {
        bibliotecaApp.setCheckedOutMovies(checkedOutItems);
    }

    @Override
    public List getAvailableItem() {
        return bibliotecaApp.getMovies();
    }

    @Override
    public List getCheckedOutItems() {
        return bibliotecaApp.getCheckedOutMovies();
    }
}
