package com.twu.biblioteca;


import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.entity.Console;
import com.twu.biblioteca.entity.Menu;
import com.twu.biblioteca.entity.Option;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
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
        inOrder.verify(console).println("Welcome to Biblioteca!!");
    }

    @Test
    public void should_list_all_books_in_repo() throws Exception {
        //given
        List<Book> books = new ArrayList<Book>();
        books.add(new Book("Head First Java"));
        books.add(new Book("Head First Html"));
        books.add(new Book("Head First Design"));

        //when
        new BibliotecaApp(console).printBooks(books);

        //then
        inOrder.verify(console).println("Head First Java");
        inOrder.verify(console).println("Head First Html");
        inOrder.verify(console).println("Head First Design");
    }

    @Test
    public void should_list_detail_info_of_book() throws Exception {

        List<Book> books = new ArrayList<Book>();
        books.add(new Book("Head First Java","Kathy Sierra Bert Bates",2007));

        new BibliotecaApp(console).printBooks(books);

        inOrder.verify(console).println("Head First Java     Kathy Sierra Bert Bates     2007");
    }

    @Test
    public void should_display_menu_after_welcome_message() throws Exception {
        List<Option> options = new ArrayList<Option>();
        options.add(new Option(1,"listBooks"));
        Menu menu = new Menu(options,console);

        new BibliotecaApp(menu,console).start();

        inOrder.verify(console,times(1)).println("Welcome to Biblioteca!!");
        inOrder.verify(console).println("**********Menu**********");
        inOrder.verify(console).println("1.listBooks");
    }

    @Test
    public void should_display_books_after_choose_listBooks_option() throws Exception {
        when(console.getNextInt()).thenReturn(1).thenReturn(0);

        new BibliotecaApp(console).start();

        inOrder.verify(console,times(1)).println("Head First Java     Kathy Sierra Bert Bates     2007");
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(null);
    }
}
