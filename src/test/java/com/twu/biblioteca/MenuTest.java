package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MenuTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void should_show_list_books_option_on_menu() throws Exception {
        List<Option> options = new ArrayList<Option>();
        options.add(new Option(1,"listBooks"));
        Menu menu = new Menu(options,new Console());

        menu.show();

        assertThat(outContent.toString(),is("**********Menu**********\n1.listBooks\n"));
    }
}
