package com.twu.biblioteca;

public class Book extends Item {
    private String author;

    public Book(String author, String title, String year, User user) {
        super(title, year, user);
        this.author = author;
    }

    public String toString() {
        return this.title + " | " + this.author + " | " + this.year;
    }
}
