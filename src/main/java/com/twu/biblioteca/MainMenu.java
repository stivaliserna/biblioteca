package com.twu.biblioteca;

import java.util.Scanner;
import java.util.List;

public class MainMenu {
    public static void execute(Biblioteca library, Scanner scanner) {
        System.out.println("Select an option:");
        System.out.println();
        System.out.println("Books:");
        System.out.println();
        System.out.println("  1) List all books");
        System.out.println("  2) Checkout a book");
        System.out.println("  3) Return a book");
        System.out.println();
        System.out.println("Movies:");
        System.out.println();
        System.out.println("  4) List all movies");
        System.out.println("  5) Checkout a movie");
        System.out.println();
        System.out.println("Account");
        System.out.println();
        System.out.println("  6) Account");
        System.out.println("  7) Quit");

        if (!scanner.hasNext()) return;

        switch (scanner.next()) {
            case "1":
                showItems(library, Book.class);
                MainMenu.execute(library, scanner);
                break;
            case "2":
                CheckoutMenu.execute(library, scanner, Book.class);
                break;
            case "3":
                ReturnMenu.execute(library, scanner, Book.class);
                break;
            case "4":
                showItems(library, Movie.class);
                MainMenu.execute(library, scanner);
                break;
            case "5":
                CheckoutMenu.execute(library, scanner, Movie.class);
                break;
            case "6":
                LoginMenu.execute(library, scanner);
                break;
            case "7":
                System.out.println("Bye!");
                break;
            default:
                System.out.println("Wrong option! Please select a valid one.");
                MainMenu.execute(library, scanner);
        }
    }

    public static void showItems(Biblioteca library, Class<? extends Item> type) {
        List<? extends Item> kek = library.findAll("", true, type);
        System.out.println(Item.formatItems(kek));
        System.out.println();
    }

    public static void goBack(Biblioteca library, Scanner scanner) {
        System.out.println();
        System.out.println("Would you like to go back to the main menu? Y/N");

        if (!scanner.hasNext()) return;

        switch (scanner.next()) {
            case "Y":
                MainMenu.execute(library, scanner);
                break;
            case "N":
                break;
            default:
                System.out.println("Sorry, invalid option.");
                goBack(library, scanner);
        }
    }
}
