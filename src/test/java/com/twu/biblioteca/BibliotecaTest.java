package com.twu.biblioteca;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class BibliotecaTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void test() {
        assertEquals(1, 1);
    }

    @Test
    public void should_show_welcome_message_when_start_application() throws Exception {
        new BibliotecaApp().start();
        assertThat(outContent.toString(), is("Welcome to Biblioteca!!"));
    }

    @Test
    public void should_list_all_books_in_repo() throws Exception {
        //given
        List<Book> books = new ArrayList<Book>();
        books.add(new Book("Head First Java"));
        books.add(new Book("Head First Html"));
        books.add(new Book("Head First Design"));

        //when
        new BibliotecaApp().printBooks(books);

        //then
        assertThat(outContent.toString(), is("Head First Java\nHead First Html\nHead First Design\n"));
    }

    @Test
    public void should_list_detail_info_of_book() throws Exception {

        List<Book> books = new ArrayList<Book>();
        books.add(new Book("Head First Java","Kathy Sierra Bert Bates",2007));

        new BibliotecaApp().printBooks(books);

        assertThat(outContent.toString(),is("Head First Java     Kathy Sierra Bert Bates     2007\n"));
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(null);
    }
}
