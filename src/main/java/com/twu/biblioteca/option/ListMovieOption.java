package com.twu.biblioteca.option;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.entity.Movie;

public class ListMovieOption extends Option {
    public static final String COLUMN_GAP = "     ";

    public ListMovieOption(int id, String name, BibliotecaApp bibliotecaApp) {
        super(id, name, bibliotecaApp);
    }

    @Override
    public void execute() {
        for (Movie movie : bibliotecaApp.getMovies()) {
            console.println(movie.toString());
        }
    }
}
