package com.twu.biblioteca.entity;

public class Book extends Item{
    public static final String COLUMN_GAP = "     ";
    private String name;
    private String author;
    private int publishYear;

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
        StringBuffer bookDesc = new StringBuffer(name);
        return name + COLUMN_GAP + author + COLUMN_GAP + publishYear;
    }
}
