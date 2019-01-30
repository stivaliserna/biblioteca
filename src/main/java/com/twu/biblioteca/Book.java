package com.twu.biblioteca;

public class Book {
    private String title;
    private String author;
    private String year;
    private Boolean borrowed;

    public Book(String title, String author, String year, Boolean borrowed) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.borrowed = false;
    }

    public String toString() {
        return this.title + " | " + this.author + " | " + this.year;
    }

    public String getTitle() {
        return title;
    }

    public Boolean getBorrowed() {
        return borrowed;
    }

    public void checkoutBook() {
        this.borrowed = true;
    }

    public void returnBook() {
        this.borrowed = false;
    }
}
