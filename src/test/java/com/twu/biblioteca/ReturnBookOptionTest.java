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

public class ReturnBookOptionTest {
    private Console console;
    private BibliotecaApp bibliotecaApp;
    private ReturnBookOption returnBookOption;

    @Before
    public void setUp() throws Exception {
        this.console = mock(Console.class);
        bibliotecaApp = new BibliotecaApp(console);
        List<Book> allBooks = new ArrayList<Book>();
        allBooks.add(new Book("Head First Java", "Kathy Sierra Bert Bates", 2007));
        List<Book> checkedOutBooks = new ArrayList<Book>();
        checkedOutBooks.add(new Book("Refactor", "Martin Flower", 2008));
        bibliotecaApp.setBooks(allBooks);
        bibliotecaApp.setCheckedOutBooks(checkedOutBooks);
        returnBookOption = new ReturnBookOption(3,"returnBook",bibliotecaApp);
    }

    @Test
    public void should_show_the_book_returned() throws Exception {
        when(console.getNextString()).thenReturn("Refactor");
        returnBookOption.execute();

        assertThat(bibliotecaApp.getBooks().size(),is(2));
        assertThat(bibliotecaApp.getBooks().get(1).getName(),is("Refactor"));
    }

    @Test
    public void should_show_failure_notification_message_when_return_book_success() throws Exception {
        when(console.getNextString()).thenReturn("Refactor");
        returnBookOption.execute();

        verify(console).println("Thank you for returning the book.");
    }

    @Test
    public void should_show_failure_message_when_return_book_failure() throws Exception {
        when(console.getNextString()).thenReturn("Refactor-incorrect");
        returnBookOption.execute();

        verify(console).println("That is not a valid book to return.");
    }
}
