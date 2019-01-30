package com.twu.biblioteca;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Biblioteca {
    private List<Book> books;

    public Biblioteca() {
        this.books = new ArrayList<Book>();
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Book> availableBooks() {
        return this.books.stream()
                         .filter(book -> book.getBorrowed() == false)
                         .collect(Collectors.toList());
    }

    public List<Book> unAvailableBooks() {
        return this.books.stream()
                         .filter(book -> book.getBorrowed() == true)
                         .collect(Collectors.toList());
    }

    public List<Book> findAll(String query) {
        return this.books.stream()
                         .filter(book -> book.getTitle().toLowerCase().contains(query))
                         .collect(Collectors.toList());
    }

    public static String formatBooks(List<Book> books) {
        return books.stream()
                    .map(Book::toString)
                    .reduce("", (String a, String b) -> String.format(a + "%n" + b));
    }
}

