package com.twu.biblioteca;

import com.twu.biblioteca.entity.*;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {
    private Menu menu;
    private Console console;
    private List<Book> books;

    public BibliotecaApp(Menu menu) {
        this.menu = menu;
        initBooks();
    }

    public BibliotecaApp(Console console) {
        this.console = console;
        this.menu = initMenu();
        initBooks();
    }

    private Menu initMenu() {
        List<Option> options = new ArrayList<Option>();
        options.add(new ListBooksOption(1, "listBooks",this));
        Menu menu = new Menu(options, new Console());
        return menu;
    }

    private List<Book> initBooks(){
        books = new ArrayList<Book>();
        books.add(new Book("Head First Java","Kathy Sierra Bert Bates",2007));
        return books;
    }

    public BibliotecaApp(Menu menu, Console console) {
        this.menu = menu;
        this.console = console;
    }

    public void start() {
        console.println("Welcome to Biblioteca!!");
        while (true) {
            menu.show();
            int chooseResult = console.getNextInt();
            if (chooseResult == 0){
                break;
            }
           menu.selectOption(chooseResult);
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
}
