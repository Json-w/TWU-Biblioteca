package com.twu.biblioteca.option;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.entity.Movie;

import java.util.ArrayList;
import java.util.List;

public class CheckOutMovieOption extends Option{
    public CheckOutMovieOption(int id, String name, BibliotecaApp bibliotecaApp) {
        super(id, name, bibliotecaApp);
    }

    @Override
    public void execute() {
        String checkoutMovieName = console.getNextString();
        List<Movie> moviesAfterCheckout = new ArrayList<Movie>();
        List<Movie> beforeCheckout = bibliotecaApp.getMovies();
        for (Movie movie : beforeCheckout) {
            if (!checkoutMovieName.equals(movie.getName())) {
                moviesAfterCheckout.add(movie);
            } else {
                bibliotecaApp.getCheckedOutMovies().add(movie);
            }
        }
        bibliotecaApp.setMovies(moviesAfterCheckout);
        if (beforeCheckout.size() > moviesAfterCheckout.size()) {
            console.println("Thank you!Enjoy the Movie");
        } else {
            console.println("That Movie is not available.");
        }
    }
}
