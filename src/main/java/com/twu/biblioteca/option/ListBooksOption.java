package com.twu.biblioteca.option;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.entity.Console;
import com.twu.biblioteca.option.Option;

public class ListBooksOption extends Option {
    public static final String COLUMN_GAP = "     ";

    private BibliotecaApp bibliotecaApp;
    private Console console;

    public ListBooksOption(int id, String name,BibliotecaApp bibliotecaApp) {
        super(id, name);
        this.bibliotecaApp = bibliotecaApp;
        this.console = bibliotecaApp.getConsole();
    }

    @Override
    public void execute() {
        for (Book book : bibliotecaApp.getBooks()) {
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
