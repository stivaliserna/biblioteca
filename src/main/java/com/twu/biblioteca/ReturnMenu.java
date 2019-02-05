package com.twu.biblioteca;

import java.util.Scanner;
import java.util.List;

public class ReturnMenu {
    public static void execute(Biblioteca library, Scanner scanner) {
        System.out.println("Type the name of the book you want to return.");

        if (!scanner.hasNext()) return;

        String query = scanner.next();

        List<Book> bookList = library.findAll(query, true);

        String result = Book.formatBooks(bookList);

        System.out.println(result);

        if (bookList.size() == 1) {
            System.out.println();
            bookList.get(0).returnBook();
            System.out.println("Thank you for returning the book!");
            MainMenu.goBack(library, scanner);
        } else if (bookList.size() == 0) {
            System.out.println("That is not a valid book to return.");
            MainMenu.goBack(library, scanner);
        } else {
            System.out.println();
            System.out.println("Be more specific, there are " + bookList.size() + " results.");
            ReturnMenu.execute(library, scanner);
        }
    }
}
