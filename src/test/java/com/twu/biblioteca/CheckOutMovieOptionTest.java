package com.twu.biblioteca;

import com.twu.biblioteca.entity.Console;
import com.twu.biblioteca.entity.Movie;
import com.twu.biblioteca.entity.User;
import com.twu.biblioteca.option.CheckOutMovieOption;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CheckOutMovieOptionTest {
    private Console console;
    private BibliotecaApp bibliotecaApp;
    private CheckOutMovieOption checkOutMovieOption;

    @Before
    public void setUp() throws Exception {
        this.console = mock(Console.class);
        bibliotecaApp = new BibliotecaApp(console);
        checkOutMovieOption = new CheckOutMovieOption(5, "checkout movie", bibliotecaApp);
        List<Movie> movies = new ArrayList<Movie>();
        movies.add(new Movie("Zootopia", 2016, "Byron Howard", 5));
        bibliotecaApp.setMovies(movies);
        bibliotecaApp.setLoginUser(new User("peiwang","123456"));
    }

    @Test
    public void should_remove_the_checked_book_after_check_out() throws Exception {
        when(console.getNextString()).thenReturn("Zootopia");

        checkOutMovieOption.execute();

        assertThat(bibliotecaApp.getMovies().size(),is(0));
        verify(console).println("Thank you!Enjoy the Movie");
    }

    @Test
    public void should_show_unavailable_information_when_checkout_failure() throws Exception {
        when(console.getNextString()).thenReturn("Zoopia");

        checkOutMovieOption.execute();

        verify(console).println("That Movie is not available.");
    }

    @Test
    public void should_record_user_who_checked_out_the_movie() throws Exception {
        when(console.getNextString()).thenReturn("Zootopia");

        checkOutMovieOption.execute();

        assertThat(bibliotecaApp.getMovies().size(),is(0));
        assertThat(bibliotecaApp.getCheckedOutMovies().get(0).getCheckOutUser(),is("peiwang"));
    }
}
