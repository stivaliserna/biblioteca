package com.twu.biblioteca;
import java.util.Scanner;

public class MainMenu {
    public static void execute(Biblioteca library, Scanner scanner) {
        System.out.println("Select an option:");
        System.out.println("  1) List all books");
        System.out.println("  2) Checkout a book");
        System.out.println("  3) Return a book");
        System.out.println("  4) Quit");

        if (!scanner.hasNext()) return;

        switch (scanner.next()) {
            case "1":
                ShowBooks.execute(library);
                MainMenu.execute(library, scanner);
                break;
            case "2":
                CheckoutMenu.execute(library, scanner);
                break;
            case "3":
                ReturnMenu.execute(library, scanner);
                break;
            case "4":
                System.out.println("Bye!");
                break;
            default:
                System.out.println("Wrong option! Please select a valid one.");
                MainMenu.execute(library, scanner);
        }
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