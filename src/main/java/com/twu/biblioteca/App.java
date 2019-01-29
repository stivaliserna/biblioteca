package com.twu.biblioteca;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Biblioteca library = new Biblioteca();

        library.addBook(new Book("Asymmetry", "Lisa Halliday", "2018"));
        library.addBook(new Book("The Great Believers", "Rebecca Makkai", "2018"));
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore.");
        System.out.println();

        mainMenu(library);
    }
    
    private static void mainMenu(Biblioteca library) {
        System.out.println("Select an option:");
        System.out.println("  1) List all books");
        System.out.println("  2) Quit");

        Scanner scanner = new Scanner(System.in);

        loop: while(scanner.hasNext()) {
            int command = scanner.nextInt();
    
            switch (command) {
                case 1:
                    showBooks(library);
                    break;
                case 2:
                    System.out.println("Bye!");
                    break loop;
                default:
                System.out.println("Wrong option! Please select a valid one.");
                mainMenu(library);
            }
        }
        scanner.close();
    }

    private static void showBooks(Biblioteca library) {
        System.out.println(library.toString());
    }
}
