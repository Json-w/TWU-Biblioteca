package com.twu.biblioteca;

import com.twu.biblioteca.entity.*;
import com.twu.biblioteca.option.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class BibliotecaApp {
    private Menu menu;
    private Console console;
    private List<Book> books;
    private int appStatus;
    private List<Book> checkedOutBooks = new ArrayList<Book>();
    private List<Movie> movies;
    private List<Movie> checkedOutMovies = new ArrayList<Movie>();
    private List<User> users;

    public BibliotecaApp(Menu menu) {
        this.menu = menu;
        initBiblioteca();
    }

    public BibliotecaApp(Console console) {
        this.console = console;
        this.menu = initMenu(this.console);
        initBiblioteca();
    }

    public BibliotecaApp(Menu menu, Console console) {
        this.menu = menu;
        this.console = console;
        initBiblioteca();
    }

    private void initBiblioteca() {
        initBooks();
        initMovies();
    }

    private Menu initMenu(Console console) {
        List<Option> options = new ArrayList<Option>();
        options.add(new ListBooksOption(1, "listBooks", this));
        options.add(new CheckOutBookOption(2, "checkout book", this));
        options.add(new ReturnBookOption(3, "return book", this));
        options.add(new ListMovieOption(4,"list movies",this));
        options.add(new ExitOption(0, "quit", this));
        Menu menu = new Menu(options, console);
        return menu;
    }

    private void initBooks() {
        books = new ArrayList<Book>();
        books.add(new Book("Head First Java", "Kathy Sierra Bert Bates", 2007));
        books.add(new Book("Refactor", "Martin Flower", 2008));
    }

    private void initMovies() {
        movies = new ArrayList<Movie>();
        movies.add(new Movie("Zootopia", 2016, "Byron Howard", null));
    }

    public void start() {
        appStatus = 1;
        console.println("Welcome to Biblioteca!!");
        while (true) {
            menu.show();
            int chooseResult;
            try {
                chooseResult = console.getNextInt();
            } catch (InputMismatchException e) {
                console.println("invalid menu option,please enter correct option.");
                continue;
            }
            menu.selectOption(chooseResult);
            if (appStatus != 1) {
                break;
            }
        }
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Console getConsole() {
        return console;
    }

    public void stop() {
        appStatus = 0;
    }

    public void setCheckedOutBooks(List<Book> checkedOutBooks) {
        this.checkedOutBooks = checkedOutBooks;
    }

    public List<Book> getCheckedOutBooks() {
        return checkedOutBooks;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public List<Movie> getCheckedOutMovies() {
        return checkedOutMovies;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }
}
