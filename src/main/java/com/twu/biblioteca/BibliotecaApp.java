package com.twu.biblioteca;

import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.entity.Console;
import com.twu.biblioteca.entity.Menu;
import com.twu.biblioteca.entity.Option;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {
    public static final String COLUMN_GAP = "     ";
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
        options.add(new Option(1, "listBooks"));
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
            for (Option option : menu.getOptions()) {
                if (chooseResult == option.getId()){
                    printBooks(books);
                }
            }
        }
    }

    public void printBooks(List<Book> books) {
        for (Book book : books) {
            StringBuffer detailInfo = formatBookInfo(book);
            console.println(detailInfo.toString());
        }
    }

    private StringBuffer formatBookInfo(Book book) {
        StringBuffer detailInfo = new StringBuffer(book.getName());
        if (book.getAuthor() != null) {
            detailInfo.append(COLUMN_GAP);
            detailInfo.append(book.getAuthor());
        }
        if (book.getPublishYear() != 0) {
            detailInfo.append("     ");
            detailInfo.append(book.getPublishYear());
        }
        return detailInfo;
    }
}
