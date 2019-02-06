package com.twu.biblioteca;

import java.util.Scanner;

public class LoginMenu {
    public static void execute(Biblioteca library, Scanner scanner) {
        if(library.isLoggedIn() == false) {
            System.out.println("Type your username");
    
            if (!scanner.hasNext()) return;
    
            String username = scanner.next();
    
            System.out.println("Type your password");
    
            String password = scanner.next();
    
            if (library.login(username, password) == true) {
                System.out.println();
                System.out.println("You're logged in!");
                AccountMenu.execute(library, scanner);
            } else {
                System.out.println();
                System.out.println("Sorry, your username/password is incorrect.");
                MainMenu.execute(library, scanner);
            }
        } else {
            AccountMenu.execute(library, scanner);
        }
    }
}
