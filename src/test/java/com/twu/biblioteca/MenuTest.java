package com.twu.biblioteca;

import com.twu.biblioteca.entity.Console;
import com.twu.biblioteca.entity.Menu;
import com.twu.biblioteca.option.ListBooksOption;
import com.twu.biblioteca.option.Option;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;

public class MenuTest {

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
    public void should_show_list_books_option_on_menu() throws Exception {
        List<Option> options = new ArrayList<Option>();
        Menu menu = new Menu(options,new Console());
        options.add(new ListBooksOption(1,"listBooks",new BibliotecaApp(menu)));

        menu.show();

        assertThat(outContent.toString(),is("**********Menu**********\n1.listBooks\n"));
    }

    @Test
    public void should_show_notification_when_input_invalid_menu_option() throws Exception {
        List<Option> options = new ArrayList<Option>();
        Menu menu = new Menu(options,console);

        menu.selectOption(2);

        inOrder.verify(console).println("invalid menu option,please enter correct option.");
    }
}
