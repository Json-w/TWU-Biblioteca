package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {
    public static final String COLUMN_GAP = "     ";
    private Menu menu;
    private Console console;

    public BibliotecaApp(Menu menu) {
        this.menu = menu;
    }

    public BibliotecaApp(Console console) {
        this.console = console;
        this.menu = initMenu();
    }

    private Menu initMenu() {
        List<Option> options = new ArrayList<Option>();
        options.add(new Option(1,"listBooks"));
        Menu menu = new Menu(options,new Console());
        return menu;
    }

    public BibliotecaApp(Menu menu, Console console) {
        this.menu = menu;
        this.console = console;
    }

    public void start(){
        console.println("Welcome to Biblioteca!!");
        menu.show();
    }

    public void printBooks(List<Book> books) {
        for (Book book : books) {
            StringBuffer detailInfo = formatBookInfo(book);
            console.println(detailInfo.toString());
        }
    }

    private StringBuffer formatBookInfo(Book book) {
        StringBuffer detailInfo = new StringBuffer(book.getName());
        if(book.getAuthor()!=null){
            detailInfo.append(COLUMN_GAP);
            detailInfo.append(book.getAuthor());
        }
        if (book.getPublishYear()!=0){
            detailInfo.append("     ");
            detailInfo.append(book.getPublishYear());
        }
        return detailInfo;
    }
}
