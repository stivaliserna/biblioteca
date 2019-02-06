package com.twu.biblioteca;

import java.util.Scanner;
import java.util.List;
import java.util.Collections;

public class CheckoutMenu {
    public static void execute(Biblioteca library, Scanner scanner, Class<? extends Item> type) {
        if(library.isLoggedIn() == true) {
            System.out.println("Type the name of the item you want to checkout.");
    
            if (!scanner.hasNext()) return;
    
            String query = scanner.next();
    
            List<? extends Item> itemList = library.findAll(query, true, type);
    
            String result = Item.formatItems(itemList);
    
            System.out.println(result);
    
            if (itemList.size() == 1 && Collections.disjoint(itemList, library.findAll("", true, type)) == false) {
                System.out.println();
                System.out.println("Thank you! Enjoy the item.");
                itemList.get(0).checkoutItem(library.getCurrentUser());
                MainMenu.goBack(library, scanner);
            } else if (Collections.disjoint(itemList, library.findAll("", true, type)) == true) {
                System.out.println();
                System.out.println("Sorry, that item is not available!");
                MainMenu.goBack(library, scanner);
            } else {
                System.out.println();
                System.out.println("Be more specific, there are " + itemList.size() + " results.");
                CheckoutMenu.execute(library, scanner, type);
            }
        } else {
            System.out.println();
            System.out.println("You must be logged to checkout an item.");
            System.out.println();
            MainMenu.execute(library, scanner);
        }
    }
}
