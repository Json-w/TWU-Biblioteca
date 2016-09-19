package com.twu.biblioteca;

public class Book {
    private String name;
    private String author;
    private int publishYear;

    public Book(String name) {
        this.name = name;
    }

    public Book(String name, String author, int publishYear) {
        this.name = name;
        this.author = author;
        this.publishYear = publishYear;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublishYear() {
        return publishYear;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publishYear=" + publishYear +
                '}';
    }
}
