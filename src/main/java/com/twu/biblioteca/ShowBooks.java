package com.twu.biblioteca;

public class ShowBooks {
    public static void execute(Biblioteca library) {
        System.out.println(Book.formatBooks(library.availableBooks()));
        System.out.println();
    }
}
