package com.twu.biblioteca.entity;

public class Movie extends Item {
    public static final String COLUMN_GAP = "     ";
    private String name;
    private int year;
    private String director;
    private Integer rating;

    public Movie(String name, int year, String director, Integer rating) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        String preStatement = name + COLUMN_GAP + director + COLUMN_GAP + year + COLUMN_GAP;
        if (rating == null) {
            return preStatement + "unrated";
        } else {
            return preStatement + rating;
        }

    }
}
