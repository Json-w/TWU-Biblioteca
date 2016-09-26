package com.twu.biblioteca.option;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.entity.Book;

import java.util.List;

public class ReturnBookOption extends ReturnItemOption {
    public ReturnBookOption(int id, String name, BibliotecaApp bibliotecaApp) {
        super(id, name, bibliotecaApp);
    }

    @Override
    public void printSuccessInfo() {
        console.println("Thank you for returning the book.");
    }

    @Override
    public void printFailureInfo() {
        console.println("That is not a valid book to return.");
    }

    @Override
    public void setCheckedOutItems(List checkedOutItems) {
        bibliotecaApp.setCheckedOutBooks(checkedOutItems);
    }

    @Override
    public List getAvailableItem() {
        return bibliotecaApp.getBooks();
    }

    @Override
    public List getCheckedOutItems() {
        return bibliotecaApp.getCheckedOutBooks();
    }

    private boolean validateBookAndDeleteItOnCheckedOutBooks(String readyReturnBookName) {
        List<Book> checkedOutBooks = bibliotecaApp.getCheckedOutBooks();
        for (Book book : checkedOutBooks) {
            if (book.getName().equals(readyReturnBookName)) {
                checkedOutBooks.remove(book);
                bibliotecaApp.getBooks().add(book);
                bibliotecaApp.setCheckedOutBooks(checkedOutBooks);
                return true;
            }
        }
        return false;
    }
}
