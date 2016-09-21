package com.twu.biblioteca;


import com.twu.biblioteca.entity.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
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
        books.add(new Book("Head First Java"));
        books.add(new Book("Head First Html"));
        books.add(new Book("Head First Design"));

        //when
        BibliotecaApp bibliotecaApp = new BibliotecaApp(console);
        bibliotecaApp.setBooks(books);
        when(console.getNextInt()).thenReturn(1).thenReturn(0);
        bibliotecaApp.start();

        //then
        inOrder.verify(console,times(1)).println("Head First Java");
        inOrder.verify(console,times(1)).println("Head First Html");
        inOrder.verify(console,times(1)).println("Head First Design");
    }

    @Test
    public void should_list_detail_info_of_book() throws Exception {

        List<Book> books = new ArrayList<Book>();
        books.add(new Book("Head First Java","Kathy Sierra Bert Bates",2007));

        BibliotecaApp bibliotecaApp = new BibliotecaApp(console);
        bibliotecaApp.setBooks(books);
        when(console.getNextInt()).thenReturn(1).thenReturn(0);
        bibliotecaApp.start();

        verify(console,times(1)).println("Head First Java     Kathy Sierra Bert Bates     2007");
    }

    @Test
    public void should_display_menu_after_welcome_message() throws Exception {
        List<Option> options = new ArrayList<Option>();
        Menu menu = new Menu(options,console);

        BibliotecaApp bibliotecaApp = new BibliotecaApp(menu, console);
        options.add(new ListBooksOption(1,"listBooks", bibliotecaApp));
        bibliotecaApp.start();

        inOrder.verify(console,times(1)).println("Welcome to Biblioteca!!");
        inOrder.verify(console).println("**********Menu**********");
        inOrder.verify(console).println("1.listBooks");
    }

    @Test
    public void should_display_books_after_choose_listBooks_option() throws Exception {
        when(console.getNextInt()).thenReturn(1).thenReturn(0);

        new BibliotecaApp(console).start();

        verify(console,times(1)).println("Head First Java     Kathy Sierra Bert Bates     2007");
    }

    @Test
    public void should_show_notification_when_input_invalid_menu_option() throws Exception {
        when(console.getNextInt()).thenReturn(2).thenReturn(1).thenReturn(0);

        new BibliotecaApp(console).start();

        inOrder.verify(console,times(1)).println("invalid menu option,please enter correct option.");
        inOrder.verify(console,times(1)).println("Head First Java     Kathy Sierra Bert Bates     2007");
    }

    @Test
    public void should_show_notification_when_catch_InputMismatchException() throws Exception {
        when(console.getNextInt()).thenThrow(InputMismatchException.class).thenReturn(0);

        new BibliotecaApp(console).start();

        verify(console,times(1)).println("invalid menu option,please enter correct option.");
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(null);
    }
}
