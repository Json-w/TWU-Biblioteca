package com.twu.biblioteca;

import com.twu.biblioteca.entity.Console;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ConsoleTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private Console console;
    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(outContent));
        console = new Console();
    }

    @Test
    public void should_print_string_without_newline() throws Exception {
        console.print("hello");

        assertThat(outContent.toString(),is("hello"));
    }

    @Test
    public void should_println_string_with_newline() throws Exception {

        console.println("hello");

        assertThat(outContent.toString(),is("hello\n"));
    }
}
