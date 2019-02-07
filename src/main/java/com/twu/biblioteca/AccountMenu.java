package com.twu.biblioteca;

import java.util.Scanner;
import java.util.List;

public class AccountMenu {
    public static void execute(Biblioteca library, Scanner scanner) {
        System.out.println();
        System.out.println("Select an option:");
        System.out.println();
        System.out.println("  1) List my checked out books");
        System.out.println("  2) View my info");
        System.out.println("  3) Logout");
        System.out.println("  4) Main menu");

        if (!scanner.hasNext()) return;

        switch (scanner.next()) {
            case "1":
                showCheckedOutBooks(library, Book.class);
                AccountMenu.execute(library, scanner);
                break;
            case "2":
                System.out.println(library.getUserInfo());
                AccountMenu.execute(library, scanner);
                break;
            case "3":
                library.logout();
                MainMenu.execute(library, scanner);
                break;
            case "4":
                MainMenu.execute(library, scanner);
                break;
            default:
                System.out.println("Wrong option! Please select a valid one.");
                System.out.println();
                MainMenu.execute(library, scanner);
        }
    }

    public static void showCheckedOutBooks(Biblioteca library, Class<? extends Item> type) {
        List<? extends Item> kek = library.findUserBooks(type);
        System.out.println(Item.formatItems(kek));
        System.out.println();
    }
}
