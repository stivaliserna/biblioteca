package com.twu.biblioteca;

import java.util.List;
import java.util.ArrayList;

public class Biblioteca {
    private List<Book> books;

    public Biblioteca() {
        this.books = new ArrayList();
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public String toString() {
        return this.books.stream()
                         .map(Book::toString)
                         .reduce("", (String a, String b) -> String.format(a + "%n" + b));
    }
}

