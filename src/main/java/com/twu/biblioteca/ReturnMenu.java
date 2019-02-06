package com.twu.biblioteca;

import java.util.Scanner;
import java.util.List;

public class ReturnMenu {
    public static void execute(Biblioteca library, Scanner scanner, Class<? extends Item> type) {
        if(library.isLoggedIn() == true) {
            System.out.println("Type the name of the book you want to return.");
    
            if (!scanner.hasNext()) return;
    
            String query = scanner.next();
    
            List<? extends Item> bookList = library.findAll(query, true, type);
    
            String result = Book.formatItems(bookList);
    
            System.out.println(result);
    
            if (bookList.size() == 1) {
                System.out.println();
                bookList.get(0).returnItem();
                System.out.println("Thank you for returning the book!");
                MainMenu.goBack(library, scanner);
            } else if (bookList.size() == 0) {
                System.out.println("That is not a valid book to return.");
                MainMenu.goBack(library, scanner);
            } else {
                System.out.println();
                System.out.println("Be more specific, there are " + bookList.size() + " results.");
                ReturnMenu.execute(library, scanner, type);
            }
        } else {
            System.out.println();
            System.out.println("You must be logged to return a book.");
            System.out.println();
            MainMenu.execute(library, scanner);
        }
    }
}
