package com.twu.biblioteca;

import com.twu.biblioteca.entity.Console;
import com.twu.biblioteca.entity.User;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LoginOptionTest {
    private BibliotecaApp bibliotecaApp;
    private Console console;


    @Before
    public void setUp() throws Exception {
        console = mock(Console.class);
        List<User> users = new ArrayList<User>();
        User user = new User("peiwang","123456");
        users.add(user);
        bibliotecaApp = new BibliotecaApp(console);
        bibliotecaApp.setUsers(users);
    }

    @Test
    public void should_login_success_when_input_correct_info() throws Exception {
        when(console.getNextString()).thenReturn("peiwang").thenReturn("123456");

        new LoginOption(9,"login",bibliotecaApp).execute();

        verify(console).println("Welcome "+ "peiwang");
    }

    @Test
    public void should_print_notification_when_input_wrong_pwd() throws Exception {
        when(console.getNextString()).thenReturn("peiwang").thenReturn("wrong-pwd");

        new LoginOption(9,"login",bibliotecaApp).execute();

        verify(console).println("please input correct username and password!");
    }

    @Test
    public void should_print_notification_when_input_wrong_username() throws Exception {
        when(console.getNextString()).thenReturn("wrong-username").thenReturn("123456");

        new LoginOption(9,"login",bibliotecaApp).execute();

        verify(console).println("please input correct username and password!");
    }
}
