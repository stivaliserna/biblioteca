package com.twu.biblioteca;

import java.util.Scanner;
import java.util.List;

public class AccountMenu {
    public static void execute(Biblioteca library, Scanner scanner) {
        System.out.println();
        System.out.println("Select an option:");
        System.out.println();
        System.out.println("  1) List my checked out books");
        System.out.println("  2) Logout");
        System.out.println("  3) Main menu");

        if (!scanner.hasNext()) return;

        switch (scanner.next()) {
            case "1":
                showCheckedOutBooks(library, Book.class);
                AccountMenu.execute(library, scanner);
                break;
            case "2":
                library.logout();
                break;
            case "3":
                MainMenu.execute(library, scanner);
                break;
            default:
                System.out.println("Wrong option! Please select a valid one.");
                MainMenu.execute(library, scanner);
        }
    }

    public static void showCheckedOutBooks(Biblioteca library, Class<? extends Item> type) {
        List<? extends Item> kek = library.findUserBooks(type);
        System.out.println(Item.formatItems(kek));
        System.out.println();
    }
}
