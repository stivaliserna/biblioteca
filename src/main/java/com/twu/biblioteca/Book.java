package com.twu.biblioteca;

import java.util.List;

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

    public static String formatBooks(List<Book> books) {
        return books.stream()
                    .map(Book::toString)
                    .reduce("", (String a, String b) -> String.format(a + "%n" + b));
    }
}
