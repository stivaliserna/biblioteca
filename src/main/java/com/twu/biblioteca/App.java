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
        library.addItem(new Book("Lisa Halliday", "Asymmetry", "2018", null));
        library.addItem(new Book("Rebecca Makkai", "The Great Believers", "2018", null));
        library.addItem(new Movie("Jonathan Demme", "10", "The Silence of the Lambs", "1991", null));
        library.addItem(new Movie("Alfonso Cuarón", "9", "Roma", "2018", null));
        library.addUser(new User("333-1234", "huehuehue"));
        library.addUser(new User("333-1235", "lol"));

        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore.");
        System.out.println();

        MainMenu.execute(library, scanner);

        scanner.close();
    }
}
