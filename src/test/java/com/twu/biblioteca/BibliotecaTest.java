package com.twu.biblioteca;


import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.entity.Console;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import static org.mockito.Mockito.*;

public class BibliotecaTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private Console console;
    private InOrder inOrder;

    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(outContent));
        console = mock(Console.class);
        inOrder = inOrder(console);
    }

    @Test
    public void should_show_welcome_message_when_start_application() throws Exception {
        new BibliotecaApp(console).start();
        verify(console).println("Welcome to Biblioteca!!");
    }

    @Test
    public void should_list_all_books_in_repo() throws Exception {
        //given
        List<Book> books = new ArrayList<Book>();
        books.add(new Book("Head First Java", "Kathy Sierra Bert Bates", 2007));
        books.add(new Book("Head First Html", "test", 2008));
        books.add(new Book("Head First Design", "test", 2009));

        //when
        BibliotecaApp bibliotecaApp = new BibliotecaApp(console);
        bibliotecaApp.setBooks(books);
        when(console.getNextInt()).thenReturn(1).thenReturn(0);
        bibliotecaApp.start();

        //then
        inOrder.verify(console, times(1)).println("Head First Java     Kathy Sierra Bert Bates     2007");
        inOrder.verify(console, times(1)).println("Head First Html     test     2008");
        inOrder.verify(console, times(1)).println("Head First Design     test     2009");
    }

    @Test
    public void should_list_detail_info_of_book() throws Exception {

        List<Book> books = new ArrayList<Book>();
        books.add(new Book("Head First Java", "Kathy Sierra Bert Bates", 2007));

        BibliotecaApp bibliotecaApp = new BibliotecaApp(console);
        bibliotecaApp.setBooks(books);
        when(console.getNextInt()).thenReturn(1).thenReturn(0);
        bibliotecaApp.start();

        verify(console, times(1)).println("Head First Java     Kathy Sierra Bert Bates     2007");
    }

    @Test
    public void should_display_menu_after_welcome_message() throws Exception {
        BibliotecaApp bibliotecaApp = new BibliotecaApp(console);
        when(console.getNextInt()).thenReturn(0);
        bibliotecaApp.start();

        inOrder.verify(console, times(1)).println("Welcome to Biblioteca!!");
        inOrder.verify(console).println("**********Menu**********");
        inOrder.verify(console).println("1.listBooks");
    }

    @Test
    public void should_display_books_after_choose_listBooks_option() throws Exception {
        when(console.getNextInt()).thenReturn(1).thenReturn(0);

        new BibliotecaApp(console).start();

        verify(console, times(1)).println("Head First Java     Kathy Sierra Bert Bates     2007");
    }

    @Test
    public void should_show_notification_when_input_invalid_menu_option() throws Exception {
        when(console.getNextInt()).thenReturn(-1).thenReturn(1).thenReturn(0);

        new BibliotecaApp(console).start();

        inOrder.verify(console, times(1)).println("invalid menu option,please enter correct option.");
        inOrder.verify(console, times(1)).println("Head First Java     Kathy Sierra Bert Bates     2007");
    }

    @Test
    public void should_show_notification_when_catch_InputMismatchException() throws Exception {
        when(console.getNextInt()).thenThrow(InputMismatchException.class).thenReturn(0);

        new BibliotecaApp(console).start();

        verify(console, times(1)).println("invalid menu option,please enter correct option.");
    }

    @Test
    public void should_exit_system_when_choose_quite_option() throws Exception {
        when(console.getNextInt()).thenReturn(1).thenReturn(0);

        new BibliotecaApp(console).start();

        inOrder.verify(console).println("Head First Java     Kathy Sierra Bert Bates     2007");
        inOrder.verify(console).println("Exit System!");
    }

    @Test
    public void should_checkout_books() throws Exception {
        when(console.getNextInt()).thenReturn(2).thenReturn(1).thenReturn(0);
        when(console.getNextString()).thenReturn("Refactor");

        new BibliotecaApp(console).start();

        inOrder.verify(console).println("2.checkout book");
        inOrder.verify(console).println("Head First Java     Kathy Sierra Bert Bates     2007");
        inOrder.verify(console).println("Exit System!");
    }

    @Test
    public void should_return_book_success() throws Exception {
        when(console.getNextInt()).thenReturn(9).thenReturn(2).thenReturn(1).thenReturn(3).thenReturn(0);
        when(console.getNextString()).thenReturn("peiwang").thenReturn("123456").thenReturn("Refactor").thenReturn("Refactor");

        new BibliotecaApp(console).start();
        inOrder.verify(console).println("3.return book");
        inOrder.verify(console).println("Thank you for returning the book.");
    }

    @Test
    public void should_list_movie_when_choose_list_movie_option() throws Exception {
        when(console.getNextInt()).thenReturn(4).thenReturn(0);

        new BibliotecaApp(console).start();
        verify(console).println("Zootopia     Byron Howard     2016     null");
    }

    @Test
    public void should_checkout_movie() throws Exception {
        when(console.getNextInt()).thenReturn(9).thenReturn(5).thenReturn(4).thenReturn(0);
        when(console.getNextString()).thenReturn("peiwang").thenReturn("123456").thenReturn("Zootopia");

        new BibliotecaApp(console).start();

        inOrder.verify(console).println("5.checkout movie");
        inOrder.verify(console,never()).println("Zootopia     Byron Howard     2016     null");
        inOrder.verify(console).println("Exit System!");
    }

    @Test
    public void should_return_movie_success() throws Exception {
        when(console.getNextInt()).thenReturn(9).thenReturn(5).thenReturn(6).thenReturn(4).thenReturn(0);
        when(console.getNextString()).thenReturn("peiwang").thenReturn("123456").thenReturn("Zootopia").thenReturn("Zootopia");

        new BibliotecaApp(console).start();

        inOrder.verify(console).println("6.return movie");
        inOrder.verify(console).println("Thank you!Enjoy the Movie");
        inOrder.verify(console).println("Zootopia     Byron Howard     2016     null");
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(null);
    }
}
