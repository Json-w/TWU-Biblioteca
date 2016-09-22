package com.twu.biblioteca;

import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.entity.Console;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CheckOutBookOptionTest {
    private Console console;

    @Before
    public void setUp() throws Exception {
        this.console = mock(Console.class);

    }

    @Test
    public void should_remove_the_checked_book_after_check_out() throws Exception {
        BibliotecaApp bibliotecaApp = new BibliotecaApp(console);
        List<Book> books = new ArrayList<Book>();
        books.add(new Book("Head First Java", "Kathy Sierra Bert Bates", 2007));
        books.add(new Book("Refactor", "Martin Flower", 2008));
        bibliotecaApp.setBooks(books);
        CheckOutBookOption checkOutBookOption = new CheckOutBookOption(2, "Check out book", bibliotecaApp);
        when(console.getNextString()).thenReturn("Refactor");

        checkOutBookOption.execute();

        assertThat(bibliotecaApp.getBooks().size(), is(1));
        assertThat(bibliotecaApp.getBooks().get(0).getName(), is("Head First Java"));
        verify(console).println("Thank you!Enjoy the book");
    }
}
