package com.twu.biblioteca;

public class Book extends Item {
    private String author;

    public Book(String author, String title, String year, Boolean borrowed) {
        super(title, year, borrowed);
        this.author = author;;
    }

    public String toString() {
        return this.title + " | " + this.author + " | " + this.year;
    }
}
