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
        return this.findAll("", false);
    }

    public List<Book> unAvailableBooks() {
        return this.findAll("", true);
    }

    public List<Book> findAll(String query, boolean borrowed) {
        return this.books.stream()
                         .filter(book -> book.getBorrowed() == borrowed)
                         .filter(book -> book.getTitle().toLowerCase().contains(query))
                         .collect(Collectors.toList());
    }
}

