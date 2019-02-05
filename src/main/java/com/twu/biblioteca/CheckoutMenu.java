package com.twu.biblioteca;

import java.util.Scanner;
import java.util.List;
import java.util.Collections;

public class CheckoutMenu {
    public static void execute(Biblioteca library, Scanner scanner) {
        System.out.println("Type the name of the book you want to checkout.");

        if (!scanner.hasNext()) return;

        String query = scanner.next();

        List<Book> bookList = library.findAll(query, false);

        String result = Book.formatBooks(bookList);

        System.out.println(result);

        if (bookList.size() == 1 && Collections.disjoint(bookList, library.availableBooks()) == false) {
            System.out.println();
            System.out.println("Thank you! Enjoy the book.");
            bookList.get(0).checkoutBook();
            MainMenu.goBack(library, scanner);
        } else if (Collections.disjoint(bookList, library.unAvailableBooks()) == true) {
            System.out.println();
            System.out.println("Sorry, that book is not available!");
            MainMenu.goBack(library, scanner);
        } else {
            System.out.println();
            System.out.println("Be more specific, there are " + bookList.size() + " results.");
            CheckoutMenu.execute(library, scanner);
        }
    }
}
