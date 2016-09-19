package com.twu.biblioteca;

import java.util.List;

public class BibliotecaApp {

    public static final String COLUMN_GAP = "     ";

    public void start(){
        System.out.print("Welcome to Biblioteca!!");
    }

    public void printBooks(List<Book> books) {
        for (Book book : books) {
            StringBuffer detailInfo = formatBookInfo(book);
            System.out.println(detailInfo.toString());
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
