package com.twu.biblioteca;

import com.twu.biblioteca.entity.Console;
import com.twu.biblioteca.entity.Movie;
import com.twu.biblioteca.option.ReturnMovieOption;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ReturnMovieOptionTest {
    private BibliotecaApp bibliotecaApp;
    private Console console;
    private ReturnMovieOption returnMovieOption;

    @Before
    public void setUp() throws Exception {
        console = mock(Console.class);
        List<Movie> checkedOutMovies = new ArrayList<Movie>();
        List<Movie> availableMovies = new ArrayList<Movie>();
        Movie movie = new Movie("Zootopia", 2016, "Byron Howard", null);
        checkedOutMovies.add(movie);
        bibliotecaApp = new BibliotecaApp(console);
        bibliotecaApp.setCheckedOutMovies(checkedOutMovies);
        bibliotecaApp.setMovies(availableMovies);
        returnMovieOption = new ReturnMovieOption(6,"return movie",bibliotecaApp);
    }

    @Test
    public void should_show_the_movie_after_returned() throws Exception {
        when(console.getNextString()).thenReturn("Zootopia");

        returnMovieOption.execute();

        assertThat(bibliotecaApp.getMovies().size(),is(1));
        assertThat(bibliotecaApp.getMovies().get(0).getName(),is("Zootopia"));
        verify(console).println("Thank you for returning the movie.");
    }

    @Test
    public void should_show_failure_notification_when_return_invalid_movie() throws Exception {
        when(console.getNextString()).thenReturn("Zootopia-incorrect");

        returnMovieOption.execute();

        verify(console).println("That is not a valid movie to return.");
    }
}
