package com.twu.biblioteca;

public class App {
    public static void main(String[] args) {
        Biblioteca library = new Biblioteca();

        library.addBook(new Book("Asymmetry", "Lisa Halliday", "2018"));
        library.addBook(new Book("The Great Believers", "Rebecca Makkai", "2018"));
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore.");
        System.out.println(library.toString());
    }
}
