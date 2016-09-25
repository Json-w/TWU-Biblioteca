package com.twu.biblioteca.option;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.entity.Console;
import com.twu.biblioteca.entity.Movie;

public class ListMovieOption extends Option {
    public static final String COLUMN_GAP = "     ";

    private BibliotecaApp bibliotecaApp;
    private Console console;

    public ListMovieOption(int id, String name, BibliotecaApp bibliotecaApp) {
        super(id, name);
        this.bibliotecaApp = bibliotecaApp;
        this.console = bibliotecaApp.getConsole();
    }

    @Override
    public void execute() {
        for (Movie movie : bibliotecaApp.getMovies()) {
            StringBuffer detailInfo = formatMovieInfo(movie);
            console.println(detailInfo.toString());
        }
    }

    private StringBuffer formatMovieInfo(Movie movie) {
        StringBuffer detailInfo = new StringBuffer(movie.getName());
        if (movie.getDirector() != null) {
            detailInfo.append(COLUMN_GAP);
            detailInfo.append(movie.getDirector());
        }
        if (movie.getYear() != 0) {
            detailInfo.append(COLUMN_GAP);
            detailInfo.append(movie.getYear());
        }
        if (movie.getRating() != null) {
            detailInfo.append(COLUMN_GAP);
            detailInfo.append(movie.getRating());
        }
        return detailInfo;
    }
}
