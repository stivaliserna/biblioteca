package com.twu.biblioteca;

public class Movie extends Item {
    private String director;
    private String rating;

    public Movie(String director, String rating, String title, String year, User user) {
        super(title, year, user);
        this.director = director;
        this.rating = rating;
    }

    public String toString() {
        return this.title + " | " + this.director + " | " + this.year + " | " + this.rating;
    }
}
