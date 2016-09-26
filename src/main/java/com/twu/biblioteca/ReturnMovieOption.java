package com.twu.biblioteca;

import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.entity.Movie;
import com.twu.biblioteca.option.Option;

import java.util.List;

public class ReturnMovieOption extends Option{
    public ReturnMovieOption(int id, String name, BibliotecaApp bibliotecaApp) {
        super(id, name, bibliotecaApp);
    }

    @Override
    public void execute() {
        String readyReturnMovieName = console.getNextString();
        if (validateMovieAndDeleteItOnCheckedOutMovies(readyReturnMovieName)) {
            console.println("Thank you for returning the movie.");
        } else {
            console.println("That is not a valid movie to return.");
        }
    }

    private boolean validateMovieAndDeleteItOnCheckedOutMovies(String readyReturnBookName) {
        List<Movie> checkedOutMovies = bibliotecaApp.getCheckedOutMovies();
        for (Movie movie: checkedOutMovies) {
            if (movie.getName().equals(readyReturnBookName)) {
                checkedOutMovies.remove(movie);
                bibliotecaApp.getMovies().add(movie);
                bibliotecaApp.setCheckedOutMovies(checkedOutMovies);
                return true;
            }
        }
        return false;
    }
}
