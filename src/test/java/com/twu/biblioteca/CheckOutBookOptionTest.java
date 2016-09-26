package com.twu.biblioteca;

import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.entity.Console;
import com.twu.biblioteca.entity.User;
import com.twu.biblioteca.option.CheckOutBookOption;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

public class CheckOutBookOptionTest {
    private Console console;
    private CheckOutBookOption checkOutBookOption;
    private BibliotecaApp bibliotecaApp;
    @Before
    public void setUp() throws Exception {
        this.console = mock(Console.class);

        bibliotecaApp = new BibliotecaApp(console);
        List<Book> books = new ArrayList<Book>();
        books.add(new Book("Head First Java", "Kathy Sierra Bert Bates", 2007));
        books.add(new Book("Refactor", "Martin Flower", 2008));
        bibliotecaApp.setBooks(books);
        bibliotecaApp.setLoginUser(new User("peiwang","123456"));
        checkOutBookOption = new CheckOutBookOption(2, "Check out book", bibliotecaApp);
    }

    @Test
    public void should_remove_the_checked_book_after_check_out() throws Exception {
        when(console.getNextString()).thenReturn("Refactor");

        checkOutBookOption.execute();

        assertThat(bibliotecaApp.getBooks().size(), is(1));
        assertThat(bibliotecaApp.getBooks().get(0).getName(), is("Head First Java"));
        verify(console).println("Thank you!Enjoy the book");
    }

    @Test
    public void should_show_unavailable_information_when_checkout_failure() throws Exception {

        when(console.getNextString()).thenReturn("Refactor-error-spell");

        checkOutBookOption.execute();
        verify(console).println("That book is not available.");
    }

    @Test
    public void should_record_user_who_checked_out_the_book() throws Exception {
        when(console.getNextString()).thenReturn("Refactor");

        checkOutBookOption.execute();

        assertThat(bibliotecaApp.getBooks().size(),is(1));
        assertThat(bibliotecaApp.getCheckedOutBooks().get(0).getCheckOutUser(),is("peiwang"));
    }
}
