package com.twu.biblioteca;

public class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String toString() {
        return this.title + " By " + this.author;
    }
}
