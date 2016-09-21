package com.twu.biblioteca;

import com.twu.biblioteca.entity.Console;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.InputMismatchException;

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

    @Test
    public void should_get_num_when_getNextInt_with_correct_input() throws Exception {
        String userInput = "1";
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));

        assertThat(console.getNextInt(),is(1));
    }

    @Test(expected = InputMismatchException.class)
    public void should_get_InputMismatchException_with_incorrect_input() throws Exception {
        String userInput = "I am String";
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));

        assertThat(console.getNextInt(),is(1));
    }

    @Test
    public void should_get_string_when_getNextString_with_input() throws Exception {
        String userInput = "refactor";
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));

        assertThat(console.getNextString(),is("refactor"));
    }
}
