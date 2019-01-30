package com.twu.biblioteca;

import java.util.Scanner;
import java.util.List;
import java.util.Collections;

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

        mainMenu();

        scanner.close();
    }

    private static void mainMenu() {
        System.out.println("Select an option:");
        System.out.println("  1) List all books");
        System.out.println("  2) Checkout a book");
        System.out.println("  3) Return a book");
        System.out.println("  4) Quit");

        if (!scanner.hasNext()) return;

        switch (scanner.next()) {
            case "1":
                showBooks();
                mainMenu();
                break;
            case "2":
                checkoutMenu();
                break;
            case "3":
                returnMenu();
                break;
            case "4":
                System.out.println("Bye!");
                break;
            default:
                System.out.println("Wrong option! Please select a valid one.");
                mainMenu();
        }
    }

    private static void showBooks() {
        System.out.println(library.formatBooks(library.availableBooks()));
        System.out.println();
    }

    private static void checkoutMenu() {
        System.out.println("Type the name of the book you want to checkout.");

        if (!scanner.hasNext()) return;

        String query = scanner.next();

        List<Book> bookList = library.findAll(query);

        String result = library.formatBooks(bookList);

        System.out.println(result);

        if (bookList.size() == 1 && !Collections.disjoint(bookList, library.unAvailableBooks()) == false) {
            System.out.println();
            System.out.println("Thank you! Enjoy the book.");
            bookList.get(0).checkoutBook();
            goBack();
        } else if (!Collections.disjoint(bookList, library.unAvailableBooks()) == true) {
            System.out.println();
            System.out.println("Sorry, that book is not available!");
            checkoutMenu();
        } else {
            System.out.println();
            System.out.println("Be more specific, there are " + bookList.size() + " results.");
            checkoutMenu();
        }
    }

    private static void returnMenu() {
        System.out.println("Type the name of the book you want to checkout.");

        if (!scanner.hasNext()) return;

        String query = scanner.next();

        List<Book> bookList = library.findAll(query);

        String result = library.formatBooks(bookList);

        System.out.println(result);

        if (bookList.size() == 1) {
            System.out.println();
            bookList.get(0).returnBook();
            System.out.println("Thank you for returning the book!");
            goBack();
        } else {
            System.out.println();
            System.out.println("Be more specific, there are " + bookList.size() + " results.");
            checkoutMenu();
        }
    }

    private static void goBack() {
        System.out.println();
        System.out.println("Would you like to go back to the main menu? Y/N");

        if (!scanner.hasNext()) return;

        switch (scanner.next()) {
            case "Y":
                mainMenu();
                break;
            case "N":
                break;
            default:
                System.out.println("Sorry, invalid option.");
                goBack();
        }
    }
}
