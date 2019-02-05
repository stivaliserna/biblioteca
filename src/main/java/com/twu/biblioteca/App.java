package com.twu.biblioteca;

import java.util.Scanner;

public class App {
    private static Biblioteca library;
    private static Scanner scanner;
    public static void main(String[] args) {
        // Initialize the library.
        library = new Biblioteca();
        // Initialize the console input scanner.
        scanner = new Scanner(System.in);

        // Add some books to the library.
        library.addBook(new Book("Asymmetry", "Lisa Halliday", "2018", false));
        library.addBook(new Book("The Great Believers", "Rebecca Makkai", "2018", false));

        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore.");
        System.out.println();

        MainMenu.execute(library, scanner);

        scanner.close();
    }
}
